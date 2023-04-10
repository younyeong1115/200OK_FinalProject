package shop.myshop.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost("smtp.naver.com"); // smtp 서버 주소
        javaMailSender.setUsername(""); // 네이버 아이디
        javaMailSender.setPassword(""); // 네이버 비밀번호

        javaMailSender.setPort(465); // 인증서버 포트

        javaMailSender.setJavaMailProperties(getMailProperties()); // 

        return javaMailSender;
    }
    
    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp"); 
        properties.setProperty("mail.smtp.auth", "true"); 
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.debug", "true"); 
        properties.setProperty("mail.smtp.ssl.trust","smtp.naver.com"); 
        properties.setProperty("mail.smtp.ssl.enable","true"); 
        return properties;
    }
}
