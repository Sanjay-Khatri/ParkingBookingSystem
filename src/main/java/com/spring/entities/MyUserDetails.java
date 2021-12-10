package com.spring.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{
	
	private String password;
	private String username;
	private List<GrantedAuthority> authorities;
	
	

	public MyUserDetails(String userName) {
		this.username = userName;
	}

	public MyUserDetails(Users user) {
		
		this.username = user.getUsername();
		this.password = user.getPassword();

		List<GrantedAuthority> a = new ArrayList<>();
		for (String role : user.getRoles().split(",")) {
			if (role.trim().toLowerCase().contains("role")) {
				a.add(new SimpleGrantedAuthority(role));
			} else {
				a.add(new SimpleGrantedAuthority("ROLE_" + role));
			}
		}	
		this.authorities = a;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
