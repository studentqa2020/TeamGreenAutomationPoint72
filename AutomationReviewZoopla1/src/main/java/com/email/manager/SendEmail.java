package com.email.manager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class SendEmail {
	
	
	public static void email() throws Throwable {
		
		HashSet<String> recepients = new HashSet<>();
		recepients.add("sarowerny@gmail.com");
		//recepients.add("sarowerqa@gmail.com");

		Email email =EmailBuilder.startingBlank()
				.from("sarowerhome@gmail.com")
				.toMultiple(recepients)
				.withSubject("Testing Mail")
				.withHTMLText(getHTML())
				.buildEmail();

		MailerBuilder.withSMTPServer("smtp.gmail.com", 587,"sarowerhome@gmail.com","tanvirj9")
		.buildMailer().sendMail(email);
	}
	
	public static String getHTML() {
	
	String html="<html>\r\n"
			+ "<head>\r\n"
			+ "<style>\r\n"
			+ "table {\r\n"
			+ "  width:75%;\r\n"
			+ "}\r\n"
			+ "table, th, td {\r\n"
			+ "  border: 1px solid black;\r\n"
			+ "  border-collapse: collapse;\r\n"
			+ "}\r\n"
			+ "th, td {\r\n"
			+ "  padding: 15px;\r\n"
			+ "  text-align: left;\r\n"
			+ "}\r\n"
			+ "#t01 tr:nth-child(even) {\r\n"
			+ "  background-color: #eee;\r\n"
			+ "}\r\n"
			+ "#t01 tr:nth-child(odd) {\r\n"
			+ " background-color: #fff;\r\n"
			+ "}\r\n"
			+ "#t01 th {\r\n"
			+ "  background-color: black;\r\n"
			+ "  color: white;\r\n"
			+ "}\r\n"
			+ "</style>\r\n"
			+ "</head>\r\n"
			+ "<body>\r\n"
			+ "\r\n"
			+ "<h2>Automation Smoke Test</h2>\r\n"
			
			+ "<table id=\"t01\">\r\n"
			+ "  <tr>\r\n"
			+ "    <th>Test Name</th>\r\n"
			+ "    <th>Test No</th> \r\n"
			+ "    <th>Status</th>\r\n"
			+ "  </tr>\r\n"
			+ "  <tr>\r\n"
			+ "    <td>Smoke (Login)</td>\r\n"
			+ "    <td>01</td>\r\n"
			+ "    <td>Passed</td>\r\n"
			+ "  </tr>\r\n"
			+ "</table>\r\n"
			+ "\r\n"
			+ "</body>\r\n"
			+ "</html>\r\n"
			+ "";
	return html;
	}
}
