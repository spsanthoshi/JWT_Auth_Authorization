
package com.neuron.admin_server.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neuron.admin_server.config.UserInfoUserDetails;
import com.neuron.admin_server.domain.User;
import com.neuron.admin_server.domain.User_Role_Mapping;
import com.neuron.admin_server.dto.Reponse;
import com.neuron.admin_server.helper.JwtHelper;
import com.neuron.admin_server.service.LoginService;
import com.neuron.admin_server.service.UserBusinessService;
import com.neuron.admin_server.service.UserRoleBusinessService;


@RestController
@RequestMapping(path = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private LoginService loginService;
  
  @Autowired
  private UserBusinessService userBussinessService;
  
  
  @Autowired
  private UserRoleBusinessService userRoleBussinessService;



  public AuthController(AuthenticationManager authenticationManager, LoginService loginService) {
    this.authenticationManager = authenticationManager;
    this.loginService = loginService;
  }

  @PostMapping("/signup")
  public ResponseEntity<Void> signup(@RequestBody User userObj) {
    loginService.signUp(userObj);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }



  @PostMapping(value = "/login")
  public ResponseEntity<Reponse> login(@RequestBody User request) {
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
      
      User existingUser =  userBussinessService.findByEmail(request.getEmail()).get();
      List<User_Role_Mapping> userRoles = userRoleBussinessService.findByUserId(existingUser.getId());
     // user.setPassword(passwordEncoder.encode(user.getPassword()));
      existingUser.setRoleNameList(new ArrayList<>());
      for(User_Role_Mapping userRole:userRoles) {
        existingUser.getRoleNameList().add(userRole.getRole().getRoleName());
      }
      existingUser.setPassword("");
      String roles = String.join(",", existingUser.getRoleNameList());
      String token = JwtHelper.generateToken(request.getEmail(),roles);
      loginService.addLoginAttempt(request, true);
      List<User> resultList = new ArrayList();
      resultList.add(existingUser);
      return new ResponseEntity<Reponse>(new Reponse(resultList, token,1), HttpStatus.OK);

      
    } catch (BadCredentialsException e) {
      loginService.addLoginAttempt(request, false);
      return new ResponseEntity<Reponse>(new Reponse(e.getMessage(), 0), HttpStatus.OK);
    }


  }


}
