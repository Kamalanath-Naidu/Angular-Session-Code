package com.player.management.pms.system.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PmsRestProfileRepositories extends JpaRepository<PmsProfileEntities,Long> {

	@Query("SELECT p FROM PmsProfileEntities p WHERE p.profile_id = :pId ")
	public PmsProfileEntities validateProfile(
	@Param("pId")long profile_id 
	
	);

	@Query("SELECT u FROM User u WHERE u.user_id = :uId ")
	public PmsProfileEntities validateUserForProfile(
	@Param("uId")long user_id 
	
	);

	
}

