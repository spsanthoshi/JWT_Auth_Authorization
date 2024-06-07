package com.neuron.admin_server.service;

import java.time.Instant;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.neuron.admin_server.constants.AppConstants;
import com.neuron.admin_server.domain.Audit;
import com.neuron.admin_server.domain.User;
import com.neuron.admin_server.exception.NeuronException;
import com.neuron.admin_server.repository.AuditRepository;
import com.neuron.admin_server.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * Queries for instaplan.json
 **/
@Service
@Slf4j
public class LoginService {
  
  @Autowired
  private UserRepository userRepo;
  
  @Autowired
  private UserBusinessService userbussinessService;
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Autowired
  private  AuditRepository auditRepo;
  
 public User signUp(User userObj) {
   Optional<User> existingUser = userbussinessService.findByEmail(userObj.getEmail());
   if (existingUser.isPresent()) {
     throw new NeuronException(
         String.format("User with the email address '%s' already exists.", userObj.getEmail()));
   }
   String password = userObj.getPassword();
   String hashedPassword = passwordEncoder.encode(userObj.getPassword());
   userObj.setPassword(hashedPassword);
   userObj.setCreatedAt(Instant.now());
   userObj.setModifiedAt(Instant.now());
   userRepo.save(userObj);
   userObj.setPassword(password);
   return userObj;
 }

public void addLoginAttempt(User user, boolean isSuccess) {
  Audit audit = new Audit();
  audit.setActivityName(AppConstants.LOGIN_ACTIVITY_NAME);
  audit.setActivityType(AppConstants.LOGIN_ACTIVITY_TYPE);
  audit.setDescription(AppConstants.LOGIN_DESCRIPTION);
  audit.setCallingAPI(AppConstants.LOGIN_CALLING_API);
  audit.setEmail(user.getEmail());
  audit.setUser_id(user.getId());
  if(isSuccess)
    audit.setStatus(AppConstants.SUCCESS_STATUS);
  else
    audit.setStatus(AppConstants.FAILURE_STATUS);
  audit.setRecordStatus(AppConstants.ACTIVE_STATUS);
  audit.setCreatedAt(Instant.now());
  audit.setModifiedAt(Instant.now());
  auditRepo.save(audit);
  
}
  
}
