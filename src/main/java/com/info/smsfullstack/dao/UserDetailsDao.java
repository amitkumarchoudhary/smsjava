package com.info.smsfullstack.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.info.smsfullstack.domain.UserDetails;

public interface UserDetailsDao extends JpaRepository<UserDetails, Integer>{
	
	@Query(value ="SELECT * FROM user_details WHERE ?1 >= start_date AND end_date >= ?2" , nativeQuery=true)
	List<UserDetails> findUserByIdDate(String start_date , String end_date);
	

}
