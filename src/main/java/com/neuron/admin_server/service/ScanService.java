package com.neuron.admin_server.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Scan;
import com.neuron.admin_server.repository.ScanRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Queries for instaplan.json
 **/
@Service
@Slf4j
public class ScanService {

  @Autowired
  ScanRepository scanRepository;


  public List<Scan> getScansByAddress(String address) {
    List<Scan> scans = scanRepository.findByAddress(address);
    return scans;
  }

  
}
