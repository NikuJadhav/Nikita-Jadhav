package mail;


import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class EmailUtils 
{
	public static void send(String to, String sub, String msg) 
	{
		// Get properties object
		try
		{
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			FileInputStream fis= new FileInputStream("f:\\config.properties");
			Properties properties = new Properties();
			properties.load(fis);
			// get Session
			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() 
			{
				return new PasswordAuthentication(properties.getProperty("mail"), properties.getProperty("pass"));
			}
		});
		// compose message
		try
		{
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} 
		catch (MessagingException e)
		{
			throw new RuntimeException(e);
		}
	}
		catch (Exception e) 
		{
			System.out.println("Error While mail sent");
		}
	}
}

