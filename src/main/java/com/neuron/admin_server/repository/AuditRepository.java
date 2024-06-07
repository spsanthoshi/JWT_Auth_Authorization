package com.neuron.admin_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neuron.admin_server.domain.Audit;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {

}