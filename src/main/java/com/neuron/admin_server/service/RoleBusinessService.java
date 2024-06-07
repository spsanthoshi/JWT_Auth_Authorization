package com.neuron.admin_server.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Role;

@Service
public class RoleBusinessService  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleDataService roleDataService;


	/**
	 * Get All Roles
	 * 
	 * @return Roles
	 */
	public List<Role> findAll() {
	  return roleDataService.findAll();
	}

	/**
	 * get the document with given id
	 * 
	 * @param entity
	 * @return Role
	 */
	public Role read(Long id) {
		return roleDataService.read(id);
	}

	/**
	 * update the document
	 * 
	 * @param entity
	 * @param id
	 * @return Role
	 */
	public Role update(Role entity, Long id) {
		Role existingEntity = roleDataService.read(id);

		if (existingEntity == null) {
			logger.error("Cannot update Role. No entity exists, with id: {}", id);
			throw new IllegalArgumentException("Cannot update Role. No entity exists with id: " + id);
		}

		return roleDataService.update(entity);
	}

	/**
	 * delete the document
	 * 
	 * @param id
	 * @return true
	 */
	public Boolean delete(Long id) {
		Role existingEntity = roleDataService.read(id);

		if (existingEntity == null) {
			logger.error("Cannot delete Role. No entity exists, with id: {}", id);
			throw new IllegalArgumentException("Cannot delete Role. No entity exists with id: " + id);
		}
		roleDataService.update(existingEntity);
		return true;
	}




}
