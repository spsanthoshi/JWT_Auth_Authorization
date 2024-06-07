package com.neuron.admin_server.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.User;
import com.neuron.admin_server.repository.UserRepository;


@Service
public class UserDataService  {

	@Autowired
	private UserRepository entityRepository;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * get document of given id
	 * 
	 * @param id
	 * @return User
	 */
	public User read(Long id) {
		return entityRepository.findById(id).get();
	}

	/**
	 * create the document
	 * 
	 * @param entity
	 * @return User
	 */
	public User save(User entity) {
		try {
			return entityRepository.save(entity);
		} catch (Exception e) {
			logger.error("User saving error: {}", e.getMessage());
			final String msg = String.format("Cannot create User.%s", e.getMessage());
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * update the document
	 *
	 * @param entity
	 * @return User
	 */
	public User update(User entity) {
		return entityRepository.save(entity);
	}


	/**
	 * @return Users
	 */
	public List<User> findAll() {
		return entityRepository.findAll();
	}

	/**
	 * get the documents based on the given number of pages
	 * 
	 * @param pageRequest
	 * @return Users
	 */
	public Page<User> findByPagination(Pageable pageRequest) {
		return entityRepository.findAll(pageRequest);
	}

	

	/**
	 * Get user by userName
	 * 
	 * @param userName
	 * @return User
	 */
	public Optional<User> findByEmailAddress(String emailAddress) {
		return entityRepository.findByEmail(emailAddress);
	}


	/**
	 * Get user by enterpriseId
	 * 
	 * @param enterpriseId
	 * @return List of User
	 */

	
}
