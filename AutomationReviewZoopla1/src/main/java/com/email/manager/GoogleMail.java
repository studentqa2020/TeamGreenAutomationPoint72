package com.email.manager;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class GoogleMail {

   public static void main(String [] args) throws Throwable, MessagingException {    
      // Recipient's email ID needs to be mentioned.
      String to = "sarowerny@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = "sarowerqa@gmail.com";

      // Assuming you are sending email from localhost
      String host = "localhost";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      Properties prop = new Properties();

      prop.put("mail.smtp.auth", true);
      prop.put("mail.smtp.starttls.enable", "true");
      prop.put("mail.smtp.host", "smtp.gmail.com");
      prop.put("mail.smtp.port", "587");
      Session session = Session.getInstance(prop, new Authenticator() {
    	    @Override
    	    protected PasswordAuthentication getPasswordAuthentication() {
    	        return new PasswordAuthentication("sarowerhome", "tanvirj9");
    	    }
    	});
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress("sarowerhome@gmail.com"));
      message.setRecipients(
        Message.RecipientType.TO, InternetAddress.parse("sarowerny@gmail.com"));
      message.setSubject("Mail Subject");

      String msg = "This is my first email using JavaMailer";

      MimeBodyPart mimeBodyPart = new MimeBodyPart();
      mimeBodyPart.setContent(msg, "text/html");

      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(mimeBodyPart);

      message.setContent(multipart);

      Transport.send(message);
   }
}