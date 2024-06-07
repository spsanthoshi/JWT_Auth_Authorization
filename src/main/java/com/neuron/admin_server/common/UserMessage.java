package com.neuron.admin_server.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserMessage {

  private String message;
  private Boolean isValidPassword = true;

  public UserMessage(String message) {
    this.message = message;
  }

}
