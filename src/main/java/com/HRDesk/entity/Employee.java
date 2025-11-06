package com.HRDesk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
  


  @Id
  @Column
  private Long empId;

  @Column
  private String name;

  @Column
  private String email; 

  @Enumerated(EnumType.STRING)
  private Status status = Status.ACTIVE;

  @Column
  private Long phoneNo;
}

