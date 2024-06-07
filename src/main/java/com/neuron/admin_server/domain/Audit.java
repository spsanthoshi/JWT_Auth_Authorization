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
@Table(name = "user_activity_tbl")
public class Audit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_activity_id")
  private Long id;

  @Column(name = "activity_name")
  private String activityName;

  @Column(name = "activity_type")
  private String activityType;

  @Column(name = "description")
  private String description;

  @Column(name = "user_email")
  private String email;
  
  @Column(name = "user_id_i")
  private Long user_id;
  
  @Column(name = "entity_id")
  private Long entityId;
  
  @Column(name = "ip_address")
  private String ipAddress;
  
  @Column(name = "calling_api")
  private String callingAPI;
  
  
  @Column(name = "status")
  private String status;
  
  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "modified_at")
  private Instant modifiedAt;
  
  @Column(name = "record_status")
  private String recordStatus;
  
  


}
