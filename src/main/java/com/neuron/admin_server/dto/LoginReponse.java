package com.neuron.admin_server.dto;

import com.neuron.admin_server.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReponse {
  
  private User user;
  private String token;
  
  public LoginReponse(User request, String token) {
     this.user = request;
     this.token = token;
  }
  

}
