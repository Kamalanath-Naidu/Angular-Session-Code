package com.player.management.pms.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.player.management.pms.system.dataAccessLayer.User;
import com.player.management.pms.system.dataAccessLayer.PmsUserProfileDTO;

public interface UserService {

//	User userLoginAuthentication(String mail, String userpasscode);
//
//	User userRegisterauth(String mail, String username);
//
//	User loginvalidation(String mail);
//
//	Page<PmsUserProfileDTO> findProfilebyUserIdPagination(Long userId, Pageable pageable);
//
//	List<User> getAllUsers();
}