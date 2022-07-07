
package com.rh.entity;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Outside {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }
  
  @Column
  private String name;
  
  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }

  @ManyToOne
  private Soumission soumission;

  public Soumission getSoumission() {
    return this.soumission;
  }

  public void setSoumission(Soumission soumission) {
    this.soumission = soumission;
  }

  @Column
  private String date;

  public String getDate() {
    return this.date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  
  @Column
  private String salary;
  
  public String getSalary() {
      try {
          return String.format("%,.2f", Double.valueOf(this.salary));
      } catch (Exception e) {
          return this.salary;
      }
  }

  public void setSalary(String salary) {
      this.salary = salary;
  }
  
  @Column
  private int nbr;
  
  public int getNbr() {
      return this.nbr;
  }

  public void setNbr(int nbr) {
      this.nbr = nbr;
  }

}
