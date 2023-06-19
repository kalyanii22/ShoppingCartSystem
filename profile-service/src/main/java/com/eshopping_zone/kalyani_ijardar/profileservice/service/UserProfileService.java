package com.eshopping_zone.kalyani_ijardar.profileservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.eshopping_zone.kalyani_ijardar.profileservice.entity.UserInfo;
import com.eshopping_zone.kalyani_ijardar.profileservice.repository.UserRepository;

@Service
public class UserProfileService  {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String registerNewUser(UserInfo userProfile) {
		
		userProfile.setPassword(passwordEncoder.encode(userProfile.getPassword()));
		repo.save(userProfile);
		return "User added successfully";
	}
	
	public UserInfo deleteExistingUser(UserInfo userId,UserInfo userProfile) {
		
		UserInfo user = repo.findByUserId(userId);
		if(user!=null) {
			repo.delete(user);
			return user;
		}
		else {
			throw new UsernameNotFoundException("User not found with id: "+userId);
		}
	}
	
	public UserInfo updateExistingUser(UserInfo userId,UserInfo userProfile) {
		
		UserInfo user = repo.findByUserId(userId);
		if(user!=null) {
			repo.delete(user);
			repo.save(userProfile);
			return userProfile;
		}
		else {
			throw new UsernameNotFoundException("User not found with id: "+userId);
		}
	}
	
	public List<UserInfo> getAllUsers() {
		
		return repo.findAll();
	}

	
	
	

}
