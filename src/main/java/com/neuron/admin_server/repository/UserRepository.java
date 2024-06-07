package com.neuron.admin_server.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neuron.admin_server.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  
  
  Optional<User> findByEmail(String email);
  Optional<User> findById(Long id);
}
