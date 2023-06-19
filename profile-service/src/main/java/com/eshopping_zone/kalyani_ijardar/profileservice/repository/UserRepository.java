package com.eshopping_zone.kalyani_ijardar.profileservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshopping_zone.kalyani_ijardar.profileservice.entity.UserInfo;


@Repository
public interface UserRepository extends JpaRepository<UserInfo, String>{

	Optional<UserInfo> findByUserName(String username);

	UserInfo findByUserId(UserInfo userId);

}
