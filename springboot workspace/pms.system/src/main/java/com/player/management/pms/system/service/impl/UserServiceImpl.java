package com.player.management.pms.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.player.management.pms.system.dataAccessLayer.PmsUserProfileDTO;
import com.player.management.pms.system.dataAccessLayer.User;
import com.player.management.pms.system.dataAccessLayer.UserRepository;
import com.player.management.pms.system.service.UserService;

//@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public User userLoginAuthentication(String mail, String userPasscode) {
//		User createdUser = userRepository.userRegisterauth(mail, userPasscode);
//		return createdUser;
//	}
//
//	@Override
//	public User userRegisterauth(String mail, String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User loginvalidation(String mail) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Page<PmsUserProfileDTO> findProfilebyUserIdPagination(Long userId, Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	public List<User> getAllUsers() {
//		return userRepository.findAll();
//	}
}