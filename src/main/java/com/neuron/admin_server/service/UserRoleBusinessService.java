package com.neuron.admin_server.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.User_Role_Mapping;

@Service
public class UserRoleBusinessService  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserRoleDataService userRoleDataService;


	/**
	 * Get All Roles
	 * 
	 * @return Roles
	 */
	public List<User_Role_Mapping> findAll() {
	  return userRoleDataService.findAll();
	}

	public List<User_Role_Mapping> findByUserId(Long userId) {
		return userRoleDataService.findByUserId(userId);
	}

}
