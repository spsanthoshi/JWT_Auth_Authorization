package com.neuron.admin_server.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Role;
import com.neuron.admin_server.domain.User;

@Service
public class UserBusinessService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDataService userDataService;

	@Autowired
	private RoleBusinessService roleBusinessService;

	@Autowired
	private EnterpriseBusinessService enterpriseBusinessService;

	
	/**
	 * @param id
	 * @return User
	 */
	public User read(Long id) {
		return userDataService.read(id);
	}

	public List<User> findAll() {
		return userDataService.findAll();
	}
	
	public Optional<User> findByEmail(String emailAddress) {
		return userDataService.findByEmailAddress(emailAddress);
	}
	


}
