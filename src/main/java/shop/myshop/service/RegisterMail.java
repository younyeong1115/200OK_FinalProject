package shop.myshop.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class RegisterMail implements MailServiceInter  {

	@Autowired
	JavaMailSender emailsender; 

	private String authCode; 

	@Override
	public MimeMessage createMessage(String to) throws MessagingException, UnsupportedEncodingException {

	    MimeMessage message = emailsender.createMimeMessage();
	    message.addRecipients(RecipientType.TO, to);
	    message.setSubject("200OK 회원가입 이메일 인증");

	    StringBuilder emailMsg = new StringBuilder();
	    emailMsg.append("<div style='margin:120px;'>")
	        .append("<div align='center' style='border:1px solid black; font-family:verdana';>")
	        .append("<h3 style='color:blue;'>회원가입 인증 코드</h3>")
	        .append("<div style='font-size:140%'>")
	        .append("<br>")
	        .append("CODE : <strong>").append(authCode).append("</strong><div><br/> "); 

	    String msg = emailMsg.toString();
	    message.setText(msg, "utf-8", "html");
	    message.setFrom(new InternetAddress("발신인 이메일", "200OK_Admin"));

	    return message;
	}

	// 랜덤 인증 코드 
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

		authCode = createKey(); 

		MimeMessage message = createMessage(to); 
		try {
			emailsender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
			throw new IllegalArgumentException();
		}


		return authCode; 
	}
}
