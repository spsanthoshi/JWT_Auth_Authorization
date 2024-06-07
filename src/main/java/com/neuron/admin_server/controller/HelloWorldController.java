package com.neuron.admin_server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/auth/hello")
public class HelloWorldController {

  
  @PostMapping("/hello")
  public ResponseEntity<String> hello() {
   
        return new ResponseEntity<String>("Hello Worlds",
            HttpStatus.OK);

  }

 
  
}
