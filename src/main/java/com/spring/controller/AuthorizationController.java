package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.AuthenticationRequest;
import com.spring.services.MyUserDetailsService;
import com.spring.utilities.JwtUtils;

@RestController
public class AuthorizationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	MyUserDetailsService myUserDetailsService;

	@Autowired
	JwtUtils jwtUtils;

	@GetMapping("/")
	public String home() {

		String msg = "<strong><a href=\"https://javaparkinglocation.herokuapp.com/swagger-ui/\">https://javaparkinglocation.herokuapp.com/swagger-ui/</a> to open swagger.<br><br><br>To see the source code visit <a href=\"https://github.com/Sanjay-Khatri/ParkingBookingSystem\">https://github.com/Sanjay-Khatri/ParkingBookingSystem</a></strong>";
		return msg;
	}

	@PostMapping(path = "/register")
	public ResponseEntity<?> register(@RequestBody(required = true) AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException badCredentialsException) {
			throw new Exception("Incorrect username or password", badCredentialsException);
		}
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String token = jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new com.spring.dto.AuthenticationResponse(token));
	}

}
