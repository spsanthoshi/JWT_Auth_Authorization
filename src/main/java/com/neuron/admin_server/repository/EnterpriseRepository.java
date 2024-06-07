package com.neuron.admin_server.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neuron.admin_server.domain.Enterprise;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

	List<Enterprise> findAll();

	Optional<Enterprise> findById(Long id);

	Enterprise findByEmail(String emailAddress);

}