package org.apache.commons.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	
	private static final String[] TEST_EMAILS = { "ab@bc.com", "a.b@c.org",
			"acbdefghijklmnopqrst@abcdefghijklmnopqrst.com.bd"};
	
	private EmailConcrete email
	private Date d = new Date(2021-25-4)
	private int connectionS = 3;
	private static final String emailName = "abc@gmail.com";
	private static final String value = "eVal";
	
	
	@Before
	public void setUpEmailTest() throws Exception{
		email = new EmailConcrete();
	}
	
	@After
	public void tearDownEmailTest() throws Exception{
		
	}
	
	@Test
	public void testAddBcc() throws Exception{
		email.addBcc(TEST_EMAILS);
		
		assertEquals(3, email.getBccAddresses().size());
	}

	@Test
	public void testAddCc() throws Exception{
		email.addCc(TEST_EMAILS);
		assertEquals(3, email.getCcAddresses().size());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void addHeader() {
		email.addHeader(value, null);
		email.addHeader(null, null);
	}
	
	@Test 
	public void addReplyTo() throws EmailException {
		email.addReplyTo(emailName, "emailName");
		//email.addReplyTo("abc.com", "0");
		//assertEquals(TEST_EMAILS, "name"); 
	}
	
	@Test (expected= EmailException.class)
	public void getMailSession() throws EmailException {
		email.getMailSession();
		
	}
	
	@Test 
	public void getSentDate() {
		email.setSentDate(d);
		email.getSentDate();
		assertEquals(d, email.getSentDate());
	}
	
	@Test
	public void getSocketConnectionTimeout() {
		email.setSocketConnectionTimeout(connectionS);
		assertSame(connectionS, email.getSocketConnectionTimeout());
	}
	
	@Test
	public void setFrom() throws EmailException{
		email.setFrom(emailName, null);	
	}

	
	@Test
	public void getHostNameTest() {
		email.setHostName(null);
		
		assertEquals(null,email.getHostName());
		
		Properties properties = new Properties();
		Session session = Session.getDefaultInstance(properties, null);
		properties.put(EmailConstants.MAIL_HOST, emailName);
		email.setMailSession(session);
		assertEquals(emailName, email.getHostName());
	}
	

	@Test 
	public void testBuildMimeMessage() throws EmailException {
		email.setHostName("localhost");
		email.setSmtpPort(1234);
		email.setFrom("a@b.com");
		email.addTo("c@d.com");
		email.setSubject("test mail");
		
		email.setCharset("ISO-8859-1");
		email.setContent("tes content", "text/plain");
		email.addBcc("test@abc.com");
		email.addCc("c@d.com");
		email.addHeader("test", "abc");
		email.getMimeMessage();
		email.getContentType();
		email.updateContentType("test content");
		email.buildMimeMessage();
		MimeMessage message = email.getMimeMessage();
		assertTrue(message instanceof MimeMessage);

		
	}
}

