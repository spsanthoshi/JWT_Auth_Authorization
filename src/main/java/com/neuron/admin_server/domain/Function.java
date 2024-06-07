package com.neuron.admin_server.domain;

import java.time.Instant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "na_function_tbl")
public class Function {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "function_id")
  private Long functionId;
  
  @Column(name = "function_name")
  private String name;
  
  @Column(name = "description")
  private String description;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "modified_at")
  private Instant modifiedAt;
}
