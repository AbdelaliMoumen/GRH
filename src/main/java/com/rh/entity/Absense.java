package com.rh.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Absense {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Column
  private String obs;

  public long getId() {
    return this.id;
  }
  
  @Column
  private String just;

  public void setId(long id) {
    this.id = id;
  }
  
  public String getObs() {
      return this.obs;
  }

  public void setObs(String obs) {
      this.obs = obs;
  }
  
  public String getJust() {
      return this.just;
  }

  public void setJust(String just) {
      this.just = just;
  }

  @ManyToOne
  private Employee employee;

  public Employee getEmployee() {
    return this.employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  @Column
  private String date;

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

}
