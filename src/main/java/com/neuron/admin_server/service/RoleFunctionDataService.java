package com.neuron.admin_server.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Role_Function_Mapping;
import com.neuron.admin_server.repository.RoleFunctionRepository;

@Service
public class RoleFunctionDataService  {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleFunctionRepository roleFuncRepository;

	
	public List<Role_Function_Mapping> findAll() {
		return roleFuncRepository.findAll();
	}

	public List<Role_Function_Mapping> findByRoleId(Long id) {
      return roleFuncRepository.findByRoleId(id);
  }


}
