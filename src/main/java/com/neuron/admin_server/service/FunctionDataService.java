package com.neuron.admin_server.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Function;
import com.neuron.admin_server.repository.FunctionRepository;

@Service
public class FunctionDataService  {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private FunctionRepository functionRepository;

	/**
	 * create the document
	 * 
	 * @param entity
	 * @return Function
	 */
	public Function save(Function entity) {
		try {
			return functionRepository.save(entity);
		} catch (Exception e) {
			logger.error("Function saving error: {}", e.getMessage());
			final String msg = String.format("Cannot create Function.%s", e.getMessage());
			throw new IllegalArgumentException(msg);
		}
	}

	

	/**
	 * @return Functions
	 */
	public List<Function> findAll() {
		return functionRepository.findAll();
	}

	/**
	 * get document of given id
	 * 
	 * @param id
	 * @return Function
	 */
	public Function read(Long id) {
		return functionRepository.findById(id).get();
	}

	/**
	 * update the document
	 * 
	 * @param entity
	 * @return Function
	 */
	public Function update(Function entity) {
		return functionRepository.save(entity);
	}

	/**
	 * get documents based on given number of pages
	 * 
	 * @param pageRequest
	 * @return Function
	 */
	public Page<Function> findByPagination(Pageable pageRequest) {
		return functionRepository.findAll(pageRequest);
	}

	/**
	 * @param String of function Ids comma Separated
	 * 
	 * @return List of Functions
	 */


}
