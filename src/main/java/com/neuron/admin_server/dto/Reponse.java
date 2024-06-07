package com.neuron.admin_server.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Reponse<T> {
  
  private List<T> data;
  private String token;
  private String errorMessage;
  private int status;
  
  public Reponse(List<T> data, String token,int status) {
     this.data = data;
     this.token = token;
     this.status =status;
  }
  public Reponse(String errorMessage, int status) {
    this.errorMessage = errorMessage;
    this.status = status;
 }

}
