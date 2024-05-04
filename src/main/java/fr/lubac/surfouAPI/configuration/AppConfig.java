package fr.lubac.surfouAPI.configuration;

import java.util.Locale;

import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;


@Configuration
public class AppConfig {
	
	//register the JTS module with Jackson : allow to serialize/deserialize GeoJson
		@Bean
		public JtsModule jtsModule()
		{
		    return new JtsModule();
		}
		
		
		 @Bean
		 public LocaleResolver localeResolver() {
			 AcceptHeaderLocaleResolver resolver = new AcceptHeaderLocaleResolver();		      
			 resolver.setDefaultLocale(Locale.US);  
			 return resolver;
		 }
		 
	
		 @Bean
		 public MessageSource messageSource() {
		     ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		     messageSource.setBasename("messages"); 
		     messageSource.setDefaultEncoding("UTF-8");
		     messageSource.setUseCodeAsDefaultMessage(true);
		     return messageSource;
		 }

}
