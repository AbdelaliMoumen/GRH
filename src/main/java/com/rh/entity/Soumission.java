package com.rh.entity;

import lombok.*;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Soumission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String dat;


    @Column
    private String occupation;

    @Column
    private String salary;

    @Column
    private String obs;

      
    //
   
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "soumission_id", insertable = false, updatable = false)
    private Set<Outside> outsides;

    //
    
    
    //
    
        
    //
    
    
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getDat() {
        return this.dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }


    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    
        
    //
    
    public Set<Outside> getOutsides() {
        return this.outsides;
    }

    public void setOutsides(Set<Outside> outsides) {
        this.outsides = outsides;
    }
    
    //

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

    public String getObs() {
        return this.obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

}
