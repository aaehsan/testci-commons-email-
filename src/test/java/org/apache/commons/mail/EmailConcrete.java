package org.apache.commons.mail;

import java.util.Date;
import java.util.Map;

public class EmailConcrete extends Email{
	
	@Override
	public Email setMsg(String msg) throws EmailException{
		return null;
	}
	
	public Map<String, String>getHeaders(){
		
		return this.headers;
	}
	
	public String getContentType() {
		return this.contentType;
	}

	public void setHeaders(String[] testEmails) {
		return;
		
	}
	
	public static Date setSentDate() {
		Date d = new Date (2021-25-4);
		return d;
	}
	
}

