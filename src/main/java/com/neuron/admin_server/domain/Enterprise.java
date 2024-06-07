package com.neuron.admin_server.domain;


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
@Table(name = "na_entity_tbl")
public class Enterprise {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "na_id")
  private Long id;

  @Column(name = "na_entity_name")
  private String name;

  @Column(name = "na_entity_description")
  private String description;

  @Column(name = "na_entity_email")
  private String email;


}
