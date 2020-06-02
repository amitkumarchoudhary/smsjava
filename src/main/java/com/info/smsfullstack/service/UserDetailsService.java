package com.info.smsfullstack.service;

import java.util.List;

import com.info.smsfullstack.domain.UserDetails;

public interface UserDetailsService {
	
 public List<UserDetails> findUserDetailsByDate(String start_date , String end_date);
}
