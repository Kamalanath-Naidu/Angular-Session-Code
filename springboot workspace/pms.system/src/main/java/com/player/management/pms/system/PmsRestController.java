package com.player.management.pms.system;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
import com.player.management.pms.system.DataAccessLayer.PmsUserProfileDTO;
import com.player.management.pms.system.SecurityService.Pms_Encrypt_Decrypt;
//import com.sun.org.apache.xerces.internal.util.URI;
import com.player.management.pms.system.DataAccessLayer.PmsJPAEntities;
import com.player.management.pms.system.DataAccessLayer.PmsJPAUserEntities;
import com.player.management.pms.system.DataAccessLayer.PmsProfileEntities;
import com.player.management.pms.system.DataAccessLayer.PmsRestProfileRepositories;
import com.player.management.pms.system.DataAccessLayer.PmsRestRepositories;
import com.player.management.pms.system.SecurityService.Pms_Encrypt_Decrypt;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/springboot")


public class PmsRestController {
	@Autowired
	private PmsRestRepositories pmsrestrepositories;
	@Autowired
	private PmsRestUserRepositories  pmsrestuserrepositories;
	@Autowired
	private PmsRestProfileRepositories pmsprofilerepositories;
	
	
//@RequestMapping("/")
	//Returns String-------------------------------------------------------------------------
	@GetMapping(path="/service")
	public String springboot() {
		return "Spring Boot Service Test";
	}
	//Returns JSON-------------------------------------------------------------------------
	@GetMapping(path="/springboot-service-module")
	public PmsServicesModule springbootTestModule() {
		
		return new PmsServicesModule("Spring Boot ServicesModule Test");
		//PmsServicesModule obj=new PmsServicesModule("Spring boot Module");
		//return obj;
}
	//Returns Emp-List from DB-------------------------------------------------------------------------
	@GetMapping(path= "/employeelist")
	    public List<PmsJPAEntities> getplayerList(){
		return pmsrestrepositories.findAll();
	}
	//Returns Emp from DB for id-------------------------------------------------------------------------
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
	//Recieves Player data from UI and adds to DB-------------------------------------------------------------------------
	public boolean x;
	@PostMapping(path="/createUserDetails")
	public PmsServiceStatus  createUserPms(@RequestBody PmsJPAUserEntities userdata){
		
		PmsServiceStatus ObjForRegister;
	
		List<PmsJPAUserEntities> users= pmsrestuserrepositories.findAll();
		
		PmsServiceStatus obj;
		x=true;
		boolean emailId_Exists=false;
		boolean userName_Exists=false;
		
		PmsJPAUserEntities usercreation = pmsrestuserrepositories.userRegisterauth(userdata.getEmail_id(),userdata.getUsername());
		
	/*	if(usercreation==null) {
			
			System.out.println(PmsServiceEnumStatus.INVALID_DATA);
			ObjForRegister=new PmsServiceStatus(PmsServiceEnumStatus.INVALID_DATA);
			return ObjForRegister;
		}
		else {
			if(usercreation.validateMailandUser(userdata,true)) {
				
				System.out.println(PmsServiceEnumStatus.USER_NAME_AND_EMAIL_ID_ALREADY_EXISTS);
				userName_Exists=true;
				emailId_Exists=true;
				ObjForRegister=new PmsServiceStatus(PmsServiceEnumStatus.USER_NAME_AND_EMAIL_ID_ALREADY_EXISTS);
				return ObjForRegister;
			}
			else {
				userName_Exists=false;
				emailId_Exists=false;
				System.out.println(PmsServiceEnumStatus.USER_DETAILS_SAVED);
				ObjForRegister=new PmsServiceStatus(PmsServiceEnumStatus.USER_DETAILS_SAVED);
				return ObjForRegister;
			}
		}*/
		
	//	userdata.setPasscode(decrypt.decrypt(userdata.getPasscode(), vectorval)); //(encrypt.encrypt(userdata.getPasscode()));;
		
		
		System.out.println("Iv: "+userdata.getCrypt());
		for(PmsJPAUserEntities userEntityObj : users) {
			
	//		if(userEntityObj.validateUserName(userdata)) {
	//			System.out.println(PmsServiceEnumStatus.USER_ALREADY_EXISTS);
		//		userName_Exists=true;
	//	}
	//		if(userEntityObj.validateEmailId(userdata)) {
	//			System.out.println(PmsServiceEnumStatus.EMAIL_ID_ALREADY_EXISTS);
//				emailId_Exists=true;
	//	}			
			
			if(userEntityObj.validateMailandUser(userdata,true)) {
				System.out.println(PmsServiceEnumStatus.USER_ALREADY_EXISTS);
				System.out.println(PmsServiceEnumStatus.EMAIL_ID_ALREADY_EXISTS);
				userName_Exists=true;
				emailId_Exists=true;
		}
			
		}
		if(userName_Exists && emailId_Exists) {
			obj = new PmsServiceStatus(PmsServiceEnumStatus.USER_NAME_AND_EMAIL_ID_ALREADY_EXISTS);
		return obj;
		}
		else if(userName_Exists==true && emailId_Exists==false) {
			obj = new PmsServiceStatus(PmsServiceEnumStatus.USER_NAME_EXISTS);
		return obj;
		}
		else if(userName_Exists==false && emailId_Exists==true) {
			obj = new PmsServiceStatus(PmsServiceEnumStatus.EMAIL_ID_EXISTS);
		return obj;
		}
		else {
			pmsrestuserrepositories.save(userdata);
			obj=new PmsServiceStatus(PmsServiceEnumStatus.USER_DETAILS_SAVED);
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
		x=false;

		List<PmsJPAUserEntities> users= pmsrestuserrepositories.findAll();
		
		PmsServiceStatus obj;
		
		boolean emailId_match=false;
		boolean password_match=false;
		
for(PmsJPAUserEntities userEntityObj : users) {
			
			/*if(userEntityObj.validatePassword(logindata)) {
				System.out.println(PmsServiceEnumStatus.PASSCODE_MATCH);
				password_match=true;
		}
			if(userEntityObj.validateEmailId(logindata)) {
				System.out.println(PmsServiceEnumStatus.EMAIL_ID_MATCH);
				emailId_match=true;
		}	*/
			if(userEntityObj.validateMailandUser(logindata,false)) {
				System.out.println(PmsServiceEnumStatus.PASSCODE_MATCH);
				System.out.println(PmsServiceEnumStatus.EMAIL_ID_MATCH);
				password_match=true;
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
	//pmsrestuserrepositories.save(logindata);
	obj=new PmsServiceStatus("PASSCODE_AND_EMAIL_ID_MISMATCH");
     return obj;   
}


	}
	
	Pms_Encrypt_Decrypt encrypt=null;
	Pms_Encrypt_Decrypt decrypt=null;
	
	@PostMapping(path="/userLoginAuth")
	public PmsServiceStatus userLoginAuthPms(@RequestBody PmsJPAUserEntities userlogdet) {
		
		PmsServiceStatus servicestatus;
		
		//PmsJPAUserEntities userlgdet= (PmsJPAUserEntities) userlgdet;
		
	
		
		PmsJPAUserEntities userAuthDetails= pmsrestuserrepositories.userLoginAuthentication(userlogdet.getEmail_id(),userlogdet.getPasscode());
		
		/*String db=decrypt.decrypt(userAuthDetails.getPasscode(),userAuthDetails.getCrypt(),userAuthDetails.getEmail_id());
		System.out.println("iv from db :"+userAuthDetails.getCrypt());
		System.out.println("Decrypted pass from db :"+db);;*/
		
		
		/**Values from ui*/
		String temp=decrypt.decrypt(userlogdet.getPasscode(), userlogdet.getCrypt(), userlogdet.getEmail_id()  );
		userlogdet.setPasscode(decrypt.decrypt(userlogdet.getPasscode(), userlogdet.getCrypt(),userlogdet.getEmail_id() ));
		
		System.out.println("iv:"+userlogdet.getCrypt());
		System.out.println("mail: "+userlogdet.getEmail_id() );
		System.out.println("Decrypted pass:"+temp);
		
		PmsJPAUserEntities secondary= pmsrestuserrepositories.loginvalidation(userlogdet.getEmail_id());
		
		String dbtest=decrypt.decrypt(secondary.getPasscode(), secondary.getCrypt(), secondary.getEmail_id()  );
		secondary.setPasscode(decrypt.decrypt(secondary.getPasscode(), secondary.getCrypt(),secondary.getEmail_id() ));
		System.out.println("iv:"+secondary.getCrypt());
		System.out.println("mail: "+secondary.getEmail_id() );
		System.out.println("Decrypted pass:"+dbtest);
		
		
		if(temp==null||dbtest==null) {
			System.out.println(PmsServiceEnumStatus.INVALID_LOGIN_CREDENTIAL);
			
			servicestatus =new PmsServiceStatus(PmsServiceEnumStatus.INVALID_LOGIN_CREDENTIAL,null,null);
					
		}
		
		else {
			if(temp.equals(dbtest)){
				System.out.println(PmsServiceEnumStatus.VALID_LOGIN);
				servicestatus =new PmsServiceStatus(PmsServiceEnumStatus.VALID_LOGIN,secondary.getFirst_name()+ " " +secondary.getLastname(),secondary.getEmail_id());
			}
			else {
				System.out.println(PmsServiceEnumStatus.INVALID_LOGIN_CREDENTIAL);
				servicestatus =new PmsServiceStatus(PmsServiceEnumStatus.INVALID_LOGIN_CREDENTIAL,null,null);
				
			}
		}
		return servicestatus;
	}
	
	
	@GetMapping(path="/encrypt")
		public String getEncryptValue() {						
			return encrypt.encrypt("kidsplay");				
	}
		
	/*@GetMapping(path="/decrypt")
		public String getDecryptValue() {
						
			return decrypt.decrypt("30WJcu6d/PLUBZtl34677A=","hfhkaajvhcxxfcsd");//  = 		
		}*/

	@GetMapping(path= "/profile")
    public List<PmsProfileEntities> getassociateprofile(){
	return pmsprofilerepositories.findAll();
}
	
	@PostMapping(path="/profile/user_id/{user_id}")
	public PmsServiceStatus createprofile(@PathVariable Long userId, @RequestBody PmsProfileEntities profiledet) {
		
		PmsServiceStatus servicestatus= null;
		
				
		PmsJPAUserEntities user=pmsrestuserrepositories.findById(userId).get();
		
		profiledet.setUsers(user);
		pmsprofilerepositories.save(profiledet);
		servicestatus=new PmsServiceStatus(PmsServiceEnumStatus.PROFILE_SAVED); 
		return servicestatus;
		
	}
	
		
	
	
	@GetMapping(path= "/profile/{user_id}/{page}/{size}")
    public ResponseEntity<Map<String,Object>> getassociateprofile(
	@PathVariable long user_id,
	@PathVariable int page,
	@PathVariable int size)
	{
	System.out.println("user:"+user_id+"page:"+page+"size:"+size);
	try {
		
		List<PmsUserProfileDTO> profile = new ArrayList<PmsUserProfileDTO>();
		
		Pageable paging =PageRequest.of(page, size);
		Page<PmsUserProfileDTO> pageobj;
		
		pageobj= pmsrestuserrepositories.findProfilebyUserIdPagination(user_id,paging);
	
		profile=pageobj.getContent(); 
		
		Map<String, Object> response =new HashMap<>();
		response.put("profiles", pageobj.getContent());
		response.put("currentPage",pageobj.getNumber());
		response.put("totalItems",pageobj.getTotalElements()); 
		response.put("totalPages",pageobj.getTotalPages());
		response.put("itemsPerPage",pageobj.getNumberOfElements());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	catch (Exception e){
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	//return pmsprofilerepositories.findAll();
	}
	

	
	
}
	
	
	
	

	