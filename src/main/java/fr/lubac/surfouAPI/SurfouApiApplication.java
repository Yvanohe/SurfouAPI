package fr.lubac.surfouAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import fr.lubac.surfouAPI.security.RsaKeyProperties;


@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SurfouApiApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(SurfouApiApplication.class, args);
	
	}

}
