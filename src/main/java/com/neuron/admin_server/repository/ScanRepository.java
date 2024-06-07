package com.neuron.admin_server.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.neuron.admin_server.domain.Scan;

@Repository
public interface ScanRepository extends JpaRepository<Scan, Long> {

  List<Scan> findByAddress(String address);
}
