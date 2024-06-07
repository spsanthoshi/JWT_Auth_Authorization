package com.neuron.admin_server.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neuron.admin_server.domain.Role_Function_Mapping;
import com.neuron.admin_server.domain.User_Role_Mapping;


@Repository
public interface UserRoleRepository extends JpaRepository<User_Role_Mapping, Long> {

	List<User_Role_Mapping> findAll();

	Optional<User_Role_Mapping> findById(Long id);

    List<User_Role_Mapping>findByUserId(Long userId);

}