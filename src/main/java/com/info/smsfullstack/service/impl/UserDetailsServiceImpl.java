package com.info.smsfullstack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.smsfullstack.dao.UserDetailsDao;
import com.info.smsfullstack.domain.UserDetails;
import com.info.smsfullstack.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailsDao userDetailsDao;
	
	@Override
	public List<UserDetails> findUserDetailsByDate(String start_date , String end_date) {
		List<UserDetails> userDetailsobj=null;
		
		if((start_date.isEmpty() && end_date.isEmpty()) || (start_date!=null && end_date!=null)) {
			userDetailsobj=userDetailsDao.findAll();
		}else {
			userDetailsobj=userDetailsDao.findUserByIdDate(start_date, end_date);
			
		}
		
		return userDetailsobj;
	}
	
	

}
