package com.neuron.admin_server.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neuron.admin_server.domain.Role_Function_Mapping;

@Repository
public interface RoleFunctionRepository extends JpaRepository<Role_Function_Mapping, Long> {

	List<Role_Function_Mapping>findAll();
	
	Optional<Role_Function_Mapping> findById(Long id);
	
	List<Role_Function_Mapping>findByRoleId(Long roleId);
}
