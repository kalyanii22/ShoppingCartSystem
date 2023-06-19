package com.eshopping_zone.kalyani_ijardar.profileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshopping_zone.kalyani_ijardar.profileservice.dto.AuthRequest;
import com.eshopping_zone.kalyani_ijardar.profileservice.entity.UserInfo;
import com.eshopping_zone.kalyani_ijardar.profileservice.service.JwtService;
import com.eshopping_zone.kalyani_ijardar.profileservice.service.UserProfileService;

@RestController
@RequestMapping("/eshoppingzone/profile")
public class UserProfileController {
	
	@Autowired
	private UserProfileService service;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/registerNewUser")
	public String registerNewUser(@RequestBody UserInfo userProfile) {
		return service.registerNewUser(userProfile);
	}
	
	@GetMapping("/info")
	public String forInfo() {
		return "This url is not secure";
	}
	@GetMapping("/forAdmin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String forAdmin() {
		return "This url is only accessible to the admin";
	}
	
	@GetMapping("/forCustomer")
	@PreAuthorize("hasAuthority('ROLE_CUSTOMER')")
	public String forCustomer() {
		return "This url is only accessible to the customer";
	}
	
	@GetMapping("/forMerchant")
	@PreAuthorize("hasAuthority('ROLE_MERCHANT')")
	public String forMerchant() {
		return "This url is only accessible to the merchant";
	}
	
	@GetMapping("/getAllUsers")
	public List<UserInfo> getAllUsers() {
		
		return service.getAllUsers();
	}
	
	@PostMapping("/authenticate")
	public String getJwtToken(@RequestBody AuthRequest authRequest) {
		
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("Invalid user request");
		}
		
	}

}
