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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "na_role_function_tbl")
public class Role_Function_Mapping {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_function_id")
  private Long id;

  @Column(name = "role_id")
  private Long roleId;


  @Column(name = "function_id")
  private Long functionId;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "function_id", referencedColumnName = "function_id",
      foreignKey = @ForeignKey(name = "na_role_func_func_mapping_fk"),insertable = false,
      updatable = false)
  private Function function;
  
  
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id", referencedColumnName = "role_id",
      foreignKey = @ForeignKey(name = "na_role_func_role_mapping_fk"),insertable = false,
      updatable = false)
  private Role role;
  
  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "modified_at")
  private Instant modifiedAt;


}
