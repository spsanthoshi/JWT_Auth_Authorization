package com.neuron.admin_server.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Role_Function_Mapping;

@Service
public class RoleFunctionBusinessService  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleFunctionDataService roleFuncDataService;


	/**
	 * Get All Roles
	 * 
	 * @return Roles
	 */
	public List<Role_Function_Mapping> findAll() {
	  return roleFuncDataService.findAll();
	}

	public List<Role_Function_Mapping> findByRoleId(Long roleId) {
      return roleFuncDataService.findByRoleId(roleId);
    }

}
