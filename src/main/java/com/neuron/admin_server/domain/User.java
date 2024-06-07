package com.neuron.admin_server.domain;

import java.time.Instant;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
@Entity
@Table(name = "na_user_tbl")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;
  
  @Column(name = "address")
  private String address;
  
  @Column(name = "phone_number")
  private String phone_number;

  @Column(name = "password")
  private String password;
  
  @Column(name = "isloggedin")
  private Integer isLoggedIn;
  
  @Transient
  private List<String> roleNameList;
  
  @Transient
  private List<Long> roleList;
  
  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "modified_at")
  private Instant modifiedAt;




}
