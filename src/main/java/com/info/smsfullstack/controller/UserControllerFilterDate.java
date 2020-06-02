package com.info.smsfullstack.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.info.smsfullstack.domain.UserDetails;
import com.info.smsfullstack.service.UserDetailsService;


@CrossOrigin(origins="*")
@RestController 
@RequestMapping(value="userdatefilter/details")
public class UserControllerFilterDate {
	
	private Logger logger=Logger.getLogger(UserControllerFilterDate.class);
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/userdatefilter" , method= RequestMethod.GET)
	@GetMapping
	public ResponseEntity getAllEmployeeDetails(
			@RequestParam(value = "start_date"  ,required = false  ) String start_date,
			@RequestParam(value = "end_date" , required = false) String end_date
			) {
		

		List<UserDetails> userDetailsObj = null;
		try {

			if (userDetailsObj == null) {			
				userDetailsObj=userDetailsService.findUserDetailsByDate(start_date,end_date);
				logger.info("getAllEmployeeDetails....." + userDetailsObj);
				
			}

		} catch (Exception e) {
			logger.debug("Error adding LandingPageController", e);
			return new ResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity(userDetailsObj, HttpStatus.OK);

	}

}
