package shop.myshop.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.internet.MimeMessage.RecipientType;
import org.springframework.stereotype.Service;

@Service
public class FindPwdEmail implements MailServiceInter {
	
	@Autowired
	JavaMailSender emailsender;


	private String tempPwd;

	// 작성
	@Override
	public MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException {

		MimeMessage message = emailsender.createMimeMessage();

		message.addRecipients(RecipientType.TO, to);// 보내는 대상
		message.setSubject("200OK 임시비밀번호 발급");

		String msgg = "";
		msgg += "<div style='margin:100px;'>";
		msgg += "<h1> 안녕하세요</h1>";
		msgg += "<h1> 200OK입니다</h1>";
		msgg += "<br>";
		msgg += "<p>회원님의 임시 비밀번호 입니다<p>";
		msgg += "<p>임시 비밀번호이므로 로그인 후 패스워드 변경 부탁드립니다.<p>";
		msgg += "<br>";
		msgg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
		msgg += "<h3 style='color:blue;'>임시 비밀번호</h3>";
		msgg += "<div style='font-size:130%'>";
		msgg += "CODE : <strong>";
		msgg += tempPwd + "</strong><div><br/> ";
		msgg += "</div>";
		message.setText(msgg, "utf-8", "html");
		message.setFrom(new InternetAddress("메일아이디", "200Ok_Admin"));

		return message;
	}

	// 랜덤 번호 
	@Override
	public String createKey() {
		StringBuffer key = new StringBuffer();
		Random rnd = new Random();

		for (int i = 0; i < 8; i++) { 
			int index = rnd.nextInt(3); 

			switch (index) {
			case 0:
				key.append((char) ((int) (rnd.nextInt(26)) + 97));
				// a~z (ex. 1+97=98 => (char)98 = 'b')
				break;
			case 1:
				key.append((char) ((int) (rnd.nextInt(26)) + 65));
				// A~Z
				break;
			case 2:
				key.append((rnd.nextInt(10)));
				// 0~9
				break;
			}
		}
		return key.toString();
	}

	// 발송
	@Override
	public String sendSimpleMessage(String to) throws Exception {
		tempPwd = createKey();

		MimeMessage message = createMessage(to);
		try {
			emailsender.send(message); 
		} catch (MailException es) {
			es.printStackTrace();
			throw new IllegalArgumentException();
		}
		return tempPwd;
	}

}
