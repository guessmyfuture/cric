package com.coeuz.cricbounz.utility;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MailSending {
   public void senMail1()
   {
	   Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("mail.cricbounz@gmail.com","rainbow26");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mail.cricbounz@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("mail.cricbounz@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler," +
					"\n\n No spam to my email, please!");

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
   }
   @Autowired
   public static boolean senMail(String toAddress,String messageContent)
   {
	   boolean isSent=false;
	   Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("mail.cricbounz@gmail.com","rainbow26");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mail.cricbounz@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toAddress));
			message.setSubject("Password Reset");
			
			//message.setText(messageContent);
			message.setContent(messageContent, "text/html");

			Transport.send(message);
			isSent=true;

		} catch (MessagingException e) {
			isSent=false;
			throw new RuntimeException(e);
		}
		return isSent;
		
   }
}
