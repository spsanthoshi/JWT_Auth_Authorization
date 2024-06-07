package com.neuron.admin_server.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Enterprise;
import com.neuron.admin_server.repository.EnterpriseRepository;

@Service
public class EnterpriseDataService  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private EnterpriseRepository enterpriseRepository;

	/**
	 * create the document
	 * 
	 * @param entity
	 * @return Enterprise
	 */
	public Enterprise save(Enterprise entity) {
		try {
			return enterpriseRepository.save(entity);
		} catch (Exception e) {
			logger.error("Enterprise saving error: {}", e.getMessage());
			final String msg = String.format("Cannot create Enterprise.%s", e.getMessage());
			throw new IllegalArgumentException(msg);
		}
	}

	/**
	 * @return Enterprises
	 */
	public List<Enterprise> findAll() {
		return enterpriseRepository.findAll();
	}


	/**
	 * update the document
	 * 
	 * @param entity
	 * @return Enterprise
	 */

	public Enterprise update(Enterprise entity) {

		return enterpriseRepository.save(entity);
	}

	

	/**
	 * get document based on given emailAddress
	 * 
	 * @param emailAddress
	 * @return Enterprise
	 */
	public Enterprise findByEmailAddress(String emailAddress) {
		return enterpriseRepository.findByEmail(emailAddress);
	}

	/**
	 * get document by id
	 * 
	 * @param id
	 * @return Enterprise
	 */
	public Optional<Enterprise> findById(Long id) {
		return enterpriseRepository.findById(id);
	}

}
