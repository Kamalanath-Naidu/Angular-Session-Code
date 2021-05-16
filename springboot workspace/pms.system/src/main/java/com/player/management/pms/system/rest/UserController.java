package com.player.management.pms.system.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.player.management.pms.system.PmsServiceEnumStatus;
import com.player.management.pms.system.PmsServiceStatus;
import com.player.management.pms.system.dataAccessLayer.User;
import com.player.management.pms.system.service.UserService;

//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/user")
public class UserController {
	
//	@Autowired
//	private UserService userService;
//	
//	@PostMapping(path = "/createUser")
//	public PmsServiceStatus createUser(@RequestBody User userData) {
//		PmsServiceStatus ObjForRegister;
//
//		List<User> users = userService.getAllUsers();
//
//		PmsServiceStatus obj;
//		boolean emailId_Exists = false;
//		boolean userName_Exists = false;
//
//		User usercreation = userService.userRegisterauth(userData.getEmail_id(), userData.getUsername());
//		System.out.println("Iv: " + userData.getCrypt());
//		System.out.println("usercreation:" + usercreation);
//		
//		for (User userEntityObj : users) {
//			if (userEntityObj.validateMailandUser(userData, true)) {
//				System.out.println(PmsServiceEnumStatus.USER_ALREADY_EXISTS);
//				System.out.println(PmsServiceEnumStatus.EMAIL_ID_ALREADY_EXISTS);
//				userName_Exists = true;
//				emailId_Exists = true;
//			}
//		}
////		if (userName_Exists && emailId_Exists) {
////			obj = new PmsServiceStatus(PmsServiceEnumStatus.USER_NAME_AND_EMAIL_ID_ALREADY_EXISTS);
////			return obj;
////		} else if (userName_Exists == true && emailId_Exists == false) {
////			obj = new PmsServiceStatus(PmsServiceEnumStatus.USER_NAME_EXISTS);
////			return obj;
////		} else if (userName_Exists == false && emailId_Exists == true) {
////			obj = new PmsServiceStatus(PmsServiceEnumStatus.EMAIL_ID_EXISTS);
////			return obj;
////		} else {
////			userRepository.save(userdata);
////			obj = new PmsServiceStatus(PmsServiceEnumStatus.USER_DETAILS_SAVED);
////			return obj;
////		}
//		return null;
//	}

}
