package fr.lubac.surfouAPI.security;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Authentication")
@RestController
@RequestMapping("/auth")
public class AuthController {

	
	 private final TokenService tokenService;

	 public AuthController(TokenService tokenService) {		 
	     this.tokenService = tokenService;
	  }
	

	//Generate Token when user is well authenticated (basic auth) on this endpoint
	@PostMapping("/login")
	public String getToken(Authentication authentication) {
		String token = tokenService.generateToken(authentication);
		return token;
	}
}
