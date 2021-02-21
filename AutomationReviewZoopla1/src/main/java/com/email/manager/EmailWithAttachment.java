package com.email.manager;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailWithAttachment {

	
	
	public static void sendmail(String recepient) throws Throwable, Throwable {
	 Properties properties = System.getProperties();

     // Setup mail server
     Properties prop = new Properties();
     prop.put("mail.smtp.auth", true);
     prop.put("mail.smtp.starttls.enable", "true");
     prop.put("mail.smtp.host", "smtp.gmail.com");
     prop.put("mail.smtp.port", "587");
    // prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
	
     String email ="sarowerhome@gmail.com";
     String pass ="tanvirj9";
     
     Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
 	    @Override
 	    protected PasswordAuthentication getPasswordAuthentication() {
 	        return new PasswordAuthentication(email, pass);
 	    }
 	});
     
     Message msg =prepareMessage(session,email,recepient);
     Transport.send(msg);
     System.out.println("Email send success");
	}
    private static Message prepareMessage(Session session,String email,String recepient) throws Throwable, MessagingException {
    	MimeMessage message = null;
    	try {
             // Create a default MimeMessage object.
              message = new MimeMessage(session);

             // Set From: header field of the header.
             message.setFrom(new InternetAddress(email));

             // Set To: header field of the header.
             message.addRecipient(Message.RecipientType.TO,new InternetAddress(recepient));

             // Set Subject: header field
             message.setSubject("This email from Java !");
             // Send the actual HTML message, as big as you like
        	   message.setContent(
                      "<h1>This is actual message embedded in HTML tags</h1>",
                     "text/html");
               
             // Create the message part 
             BodyPart messageBodyPart = new MimeBodyPart();

             // Fill the message
            // messageBodyPart.setText("This is message body");
             messageBodyPart.setContent(
                     "<h1>This is html</h1>",
                    "text/html");
             // Create a multipar message
             Multipart multipart = new MimeMultipart();

             // Set text message part
             multipart.addBodyPart(messageBodyPart);

            
             
             
             // Part two is attachment
             messageBodyPart = new MimeBodyPart();
             String filename = "./target/Advance-cucumber-reports/cucumber-html-reports/report-tag_TC_001.html";
             DataSource source = new FileDataSource(filename);
             messageBodyPart.setDataHandler(new DataHandler(source));
             messageBodyPart.setFileName(filename);
             multipart.addBodyPart(messageBodyPart);

             // Send the complete message parts
             message.setContent(multipart );

            
             System.out.println("Sent message successfully....");
          } catch (MessagingException mex) {
             mex.printStackTrace();
          }
    	  
    	  
    	  return message;	 
    	 
     }
     
    public static void main(String[] args) throws Throwable {
    	EmailWithAttachment.sendmail("sarowerhome@gmail.com");
	}
}

