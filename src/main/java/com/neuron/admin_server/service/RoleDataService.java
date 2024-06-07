package com.neuron.admin_server.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Role;
import com.neuron.admin_server.repository.RoleRepository;

@Service
public class RoleDataService  {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleRepository roleRepository;

	/**
	 * create the document
	 * 
	 * @param entity
	 * @return Role
	 */
	public Role save(Role entity) {
		try {
			return roleRepository.save(entity);
		} catch (Exception e) {
			logger.error("Role saving error: {}", e.getMessage());
			final String msg = String.format("Cannot create Role.%s", e.getMessage());
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * @return Roles
	 */
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	/**
	 * get document of given id
	 * 
	 * @param id
	 * @return Role
	 */
	public Role read(Long id) {
		return roleRepository.findById(id).get();
	}

	/**
	 * delete the document
	 * 
	 * @param id
	 * @return Alarm
	 */
	public Boolean delete(Long id) {
		roleRepository.deleteById(id);
		return true;
	}

	/**
	 * update the document
	 * 
	 * @param entity
	 * @return Role
	 */

	public Role update(Role entity) {

		return roleRepository.save(entity);
	}

	/**
	 * get documents based on given number of pages
	 * 
	 * @param pageRequest
	 * @return Role
	 */
	public Page<Role> findByPagination(Pageable pageRequest) {
		return roleRepository.findAll(pageRequest);
	}

	/**
	 * @param String of role ids comma separated
	 * 
	 * @return List of Roles with that ids
	 */


}
