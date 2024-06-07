package com.neuron.admin_server.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Function;

@Service
public class FunctionBusinessService  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FunctionDataService functionDataService;
	

	
	/**
	 * Get All Functions
	 * 
	 * @return Functions
	 */
	public List<Function> findAll() {
		return functionDataService.findAll();
	}

	/**
	 * get the document with given id
	 * 
	 * @param entity
	 * @return Function
	 */
	public Function read(Long id) {
		return functionDataService.read(id);
	}

	/**
	 * update the document
	 * 
	 * @param entity
	 * @param id
	 * @return Function
	 */
	public Function update(Function entity, Long id) {
		Function existingEntity = functionDataService.read(id);

		if (existingEntity == null) {
			logger.error("Cannot update Function. No entity exists, with id: {}", id);
			throw new IllegalArgumentException("Cannot update Function. No entity exists with id: " + id);
		}
		return functionDataService.update(entity);
	}



}
