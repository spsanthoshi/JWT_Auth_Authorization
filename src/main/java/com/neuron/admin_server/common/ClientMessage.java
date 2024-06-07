package com.neuron.admin_server.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientMessage {

  private String message;
  private Boolean isLoggedIn = false;

  public ClientMessage(String message) {
    this.message = message;
  }

}
