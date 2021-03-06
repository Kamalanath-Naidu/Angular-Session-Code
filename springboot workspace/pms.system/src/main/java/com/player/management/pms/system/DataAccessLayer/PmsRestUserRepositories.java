package com.player.management.pms.system.DataAccessLayer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.player.management.pms.system.SecurityService.Pms_Encrypt_Decrypt;
import com.player.management.pms.system.DataAccessLayer.PmsUserProfileDTO;


@Repository

public interface PmsRestUserRepositories extends JpaRepository<PmsJPAUserEntities,Long>{

	Pms_Encrypt_Decrypt decrypt=null;
	
@Query("SELECT u FROM PmsJPAUserEntities u WHERE u.email_id = :uMail and u.passcode = :uPcode")
public PmsJPAUserEntities userLoginAuthentication(
		@Param("uMail")String mail,
        @Param("uPcode")String userpasscode
        );

@Query("SELECT u FROM PmsJPAUserEntities u WHERE u.email_id = :uMail and u.username = :uUname")
public PmsJPAUserEntities userRegisterauth(
		@Param("uMail")String mail,
        @Param("uUname")String username
        );

@Query("SELECT u FROM PmsJPAUserEntities u WHERE u.email_id = :uMail ")
public PmsJPAUserEntities loginvalidation(
		@Param("uMail")String mail
        
        );



@Query("SELECT new  com.player.management.pms.system.DataAccessLayer.PmsUserProfileDTO(u.user_id,u.email_id,p.profile_id ,p.first_name,p.last_name,p.nuemail_id,p.phone,p.gender,p.undergrade,p.postgrade,p.techeng,p.exp,p.preproject) FROM PmsJPAUserEntities u INNER JOIN u.profiles  p  WHERE u.user_id = :uId order by p.profile_id desc")
Page<PmsUserProfileDTO> findProfilebyUserIdPagination(@Param("uId") Long userId, Pageable pageable);
 

}
