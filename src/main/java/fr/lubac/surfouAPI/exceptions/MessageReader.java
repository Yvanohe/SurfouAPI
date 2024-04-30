package fr.lubac.surfouAPI.exceptions;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageReader {
	
	@Autowired
	private MessageSource messageSource;
	
	public String getMessageErreur (int code, Locale locale) {
		String message;
		try {
			message = messageSource.getMessage(String.valueOf(code), null, locale);
		} catch (Exception e) {
			System.out.println(e);
			message = "An unknown error occured";
		}
		return message;
	};

}
