package com.neuron.admin_server.domain;


import java.time.Instant;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "na_user_role_tbl")
public class User_Role_Mapping {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_role_id")
  private Long id;

  @Column(name = "role_id")
  private Long roleId;

  @Column(name = "user_id")
  private Long userId;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", referencedColumnName = "id",
      foreignKey = @ForeignKey(name = "fk_user_user_role_id"),insertable = false,
      updatable = false)
  private User user;
  
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id", referencedColumnName = "role_id",
      foreignKey = @ForeignKey(name = "fk_role_user_role_id"),insertable = false,
      updatable = false)
  private Role role;

  
  
  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "modified_at")
  private Instant modifiedAt;

  

}
