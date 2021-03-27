package com.player.management.pms.system;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.player.management.pms.system.DataAccessLayer.PmsRestRepositories;
import com.player.management.pms.system.DataAccessLayer.PmsRestUserRepositories;
//import com.sun.org.apache.xerces.internal.util.URI;
import com.player.management.pms.system.DataAccessLayer.PmsJPAEntities;
import com.player.management.pms.system.DataAccessLayer.PmsJPAUserEntities;
import com.player.management.pms.system.DataAccessLayer.PmsRestRepositories;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/springboot")


public class PmsRestController {
	@Autowired
	private PmsRestRepositories pmsrestrepositories;
	@Autowired
	private PmsRestUserRepositories  pmsrestuserrepositories;
//@RequestMapping("/")
	@GetMapping(path="/service")
	public String springboot() {
		return "Spring Boot Service Test";
	}
	@GetMapping(path="/springboot-service-module")
	public PmsServicesModule springbootTestModule() {
		
		//return new PmsServicesModule("Spring Boot ServicesModule Test");
		PmsServicesModule obj=new PmsServicesModule("Spring boot Module");
		return obj;
}
	@GetMapping(path= "/employeelist")
	    public List<PmsJPAEntities> getplayerList(){
		return pmsrestrepositories.findAll();
	}
	@GetMapping(path= "/employeelist/{plyId}")
    public PmsJPAEntities getplayerRecord(@PathVariable long plyId){
	return pmsrestrepositories.findById(plyId).get();
}
	/*@PostMapping(path="/springboot/createUserDetails")
	public ResponseEntity<Void>  createUserPms(@RequestBody PmsJPAUserEntities userdata){
	
		PmsJPAUserEntities createdUserPms = pmsrestuserrepositories.save(userdata);
		
		URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdUserPms.getUser_id()).toUri();
	
		return ResponseEntity.created(uri).build();
	}*/
	@PostMapping(path="/createUserDetails")
	public PmsServiceStatus  createUserPms(@RequestBody PmsJPAUserEntities userdata){
	
		List<PmsJPAUserEntities> users= pmsrestuserrepositories.findAll();
		
		PmsServiceStatus obj;
		
		boolean emailId_Exists=false;
		boolean userName_Exists=false;
		
		for(PmsJPAUserEntities userEntityObj : users) {
			
			if(userEntityObj.validateUserName(userdata)) {
				System.out.println(PmsServiceEnumStatus.USER_ALREADY_EXISTS);
				userName_Exists=true;
		}
			if(userEntityObj.validateEmailId(userdata)) {
				System.out.println(PmsServiceEnumStatus.EMAIL_ID_ALREADY_EXISTS);
				emailId_Exists=true;
		}			
			
		}
		if(userName_Exists && emailId_Exists) {
			obj = new PmsServiceStatus("USER_NAME_AND_EMAIL_ID_ALREADY_EXISTS");
		return obj;
		}
		else if(userName_Exists==true && emailId_Exists==false) {
			obj = new PmsServiceStatus("USER_NAME_EXISTS");
		return obj;
		}
		else if(userName_Exists==false && emailId_Exists==true) {
			obj = new PmsServiceStatus("EMAIL_ID_EXISTS");
		return obj;
		}
		else {
			pmsrestuserrepositories.save(userdata);
			obj=new PmsServiceStatus("USER_DETAILS_SAVED");
             return obj;
		}
			
	
	}
		
	
	@GetMapping(path= "/userlist")
    public List<PmsJPAUserEntities> getUserList(){
	return pmsrestuserrepositories.findAll();
}
	@GetMapping(path = "/userRecord/{user_id}")
    public PmsJPAUserEntities getUserRecord(@PathVariable long user_id){
        return pmsrestuserrepositories.findById(user_id).get();
    }
	
	@PostMapping(path="/authenticateUser")
	public PmsServiceStatus  Loginuser(@RequestBody PmsJPAUserEntities logindata){
		

		List<PmsJPAUserEntities> users= pmsrestuserrepositories.findAll();
		
		PmsServiceStatus obj;
		
		boolean emailId_match=false;
		boolean password_match=false;
		
for(PmsJPAUserEntities userEntityObj : users) {
			
			if(userEntityObj.validatePassword(logindata)) {
				System.out.println(PmsServiceEnumStatus.PASSCODE_MATCH);
				password_match=true;
		}
			if(userEntityObj.validateEmailId(logindata)) {
				System.out.println(PmsServiceEnumStatus.EMAIL_ID_MATCH);
				emailId_match=true;
		}			
			
		}
if(password_match && emailId_match) {
	obj = new PmsServiceStatus("PASSCODE_AND_EMAIL_ID_MATCHES");
return obj;
}
else if(password_match==true && emailId_match==false) {
	obj = new PmsServiceStatus("PASSCODE_MATCH_EMAIL_ID_MISMATCH");
return obj;
}
else if(password_match==false && emailId_match==true) {
	obj = new PmsServiceStatus("PASSCODE_MISMATCH_EMAIL_ID_MATCH");
return obj;
}
else {
	pmsrestuserrepositories.save(logindata);
	obj=new PmsServiceStatus("PASSCODE_AND_EMAIL_ID_MISMATCH");
     return obj;   
}


	}
	
	}
	
	
	
	

	