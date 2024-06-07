package com.neuron.admin_server.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.domain.Enterprise;

@Service
public class EnterpriseBusinessService  {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private EnterpriseDataService enterpriseDataService;




  /**
   * Get All Enterprises
   * 
   * @return Enterprises
   */

  public List<Enterprise> findAll() {
    return enterpriseDataService.findAll();
  }




  public Enterprise findByEmail(String emailAddress) {
    return enterpriseDataService.findByEmailAddress(emailAddress);
  }
  
  public Enterprise findById(Long id) {
    Optional<Enterprise> enterprise = enterpriseDataService.findById(id);
    if(enterprise.isPresent()) {
      return enterprise.get();
    }
    return null;
  }
  
}
