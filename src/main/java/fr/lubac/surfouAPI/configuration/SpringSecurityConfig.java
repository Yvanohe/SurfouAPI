package fr.lubac.surfouAPI.configuration;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

@Configuration
public class SpringSecurityConfig {
	
	private String jwtKey="orRFaPSknPhKvdVEfsulkWGsyiZHKFJa";
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		
		return http.csrf(csrf -> csrf.disable()) //useless csrf protection because 1/no session cookie(statless) and use of a Bearer token
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //no session cookie(statless) 
				.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) //All request need authentication
				.httpBasic(Customizer.withDefaults()) // use of Basic Auth (will change to Bearer token)
				.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()))
				.build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("password")).roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}
	
	
	
	@Bean
	public JwtDecoder jwtDecoder() {
		SecretKeySpec secretKey = new SecretKeySpec(this.jwtKey.getBytes(), 0, this.jwtKey.getBytes().length,"RSA");
		return NimbusJwtDecoder.withSecretKey(secretKey).macAlgorithm(MacAlgorithm.HS256).build();
	}
	
	@Bean
	public JwtEncoder jwtEncoder() {
		return new NimbusJwtEncoder(new ImmutableSecret<>(this.jwtKey.getBytes()));
	}
	
}
