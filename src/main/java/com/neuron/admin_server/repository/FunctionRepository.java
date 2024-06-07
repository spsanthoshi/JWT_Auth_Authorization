package com.neuron.admin_server.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.neuron.admin_server.domain.Function;

@Repository
public interface FunctionRepository extends JpaRepository<Function, Long> {

	List<Function>findAll();
	
	Optional<Function> findById(Long id);
	

}
