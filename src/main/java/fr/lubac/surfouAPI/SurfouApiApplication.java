package fr.lubac.surfouAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import fr.lubac.surfouAPI.security.RsaKeyProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = {@Server(url = "/v1", description = "Default Server URL")})
@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class SurfouApiApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(SurfouApiApplication.class, args);
	
	}

}
