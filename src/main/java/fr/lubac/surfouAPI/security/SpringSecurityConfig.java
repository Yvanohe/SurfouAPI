package fr.lubac.surfouAPI.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	//private String jwtKey="orRFaPSknPhKvdVEfsulkWGsyiZHKFJa";
	private final RsaKeyProperties rsaKeys;
	
	public SpringSecurityConfig( RsaKeyProperties rsaKeys) {
		this.rsaKeys = rsaKeys;
	}
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		
		return http.csrf(csrf -> csrf.disable()) //useless csrf protection because 1/no session cookie(statless) and use of a Bearer token
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //no session cookie(statless) 
				.authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) //All request need authentication				
				.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults())) // Bearer token
				.build();
	}
	
	// this filter chain to allow Basic Auth only on "/auth/login". It will be checked first
	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	public SecurityFilterChain tokenSecurityFilterChain (HttpSecurity http) throws Exception {
		
		return http.securityMatcher(new AntPathRequestMatcher("/auth/login"))
				.csrf(csrf -> csrf.disable()) //useless csrf protection because 1/no session cookie(statless) and use of a Bearer token
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //no session cookie(statless) 
				.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()) // use of Basic Auth 	
				.build();				
	}
	
	
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//For test purpose : create an user in memory
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("password")).roles("USER").build();
		return new InMemoryUserDetailsManager(user);
	}
	
	
	
	//Decode jwt Token with public key
	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
	}
	
	//Encode a jwt token with private keys after user is authenticated
	@Bean
	public JwtEncoder jwtEncoder() {
		JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();
		JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
		return new NimbusJwtEncoder(jwks);
	}
	
}
