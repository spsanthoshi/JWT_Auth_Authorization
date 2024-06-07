package com.neuron.admin_server.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.User_Role_Mapping;
import com.neuron.admin_server.repository.UserRoleRepository;

@Service
public class UserRoleDataService  {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserRoleRepository userRoleRepo;


	public List<User_Role_Mapping> findAll() {
		return userRoleRepo.findAll();
	}

	public List<User_Role_Mapping> findByUserId(Long id) {
      return userRoleRepo.findByUserId(id);
  }


}
