package com.spring.dto;

public class 
AuthenticationResponse {

	private String secureToken;

	public AuthenticationResponse(String secureToken) {
		this.secureToken = secureToken;
	}

	public String getSecureToken() {
		return secureToken;
	}

	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}
	
	
}
