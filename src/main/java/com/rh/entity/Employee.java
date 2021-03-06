package com.rh.entity;

import lombok.*;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
//import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String cin;

    @Column
    private String address;

    @Column
    private String phone;
    
    //
    
    @Column
    private String fixe;
    
    @Column
    private String countr;
    
    @Column
    private String ville;
    
    @Column
    private String martial;
    
    @Column
    private String sexe;
    
    @Column
    private String nss;
    
    @Column
    private String langue;
    
    @Column
    private String distance;
    
    @Column
    private String enfant;
    
    @Column
    private String visa;
    
    @Column
    private String travail;
    
    @Column
    private String dvisa;
    
    @Column
    private String dtravail;

    @Column
    private String email;

    @Column
    private String birth;

    @Column
    private String contractStart;

    @Column
    private String contractEnd;

    @Column
    private String occupation;

    @Column
    private String password;

    @Column
    private Boolean isAdmin;

    @Column
    private String salary;
    
    @Column
    private String hdt;

    @Column
    private String obs;
    
    //
    
    /*@Transient
	private MultipartFile userImage;*/
    
    //

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Set<Vacation> vacations;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Set<Absense> absenses;

    
    //
   
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Set<Paiment> paiments;

    //
    

    //
    
    @ManyToOne()
    private Department department;

    public Department getDepartment() {
      return this.department;
    }

    public void setDepartment(Department department) {
      this.department = department;
    }
    
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

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
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
    //
    
    public String getFixe() {
        return this.fixe;
    }

    public void setFixe(String fixe) {
        this.fixe = fixe;
    }
    
    public String getHdt() {
        return this.hdt;
    }

    public void setHdt(String hdt) {
        this.hdt = hdt;
    }
    
    public String getCountr() {
        return this.countr;
    }

    public void setCountr(String countr) {
        this.countr = countr;
    }
    
    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    public String getMartial() {
        return this.martial;
    }

    public void setMartial(String martial) {
        this.martial = martial;
    }
    
    public String getSexe() {
        return this.sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    public String getNss() {
        return this.nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }
    
    public String getLangue() {
        return this.langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }
    
    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
    
    public String getEnfant() {
        return this.enfant;
    }

    public void setEnfant(String enfant) {
        this.enfant = enfant;
    }
    
    public String getVisa() {
        return this.visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }
    
    public String getTravail() {
        return this.travail;
    }

    public void setTravail(String travail) {
        this.travail = travail;
    }
    
    public String getDvisa() {
        return this.dvisa;
    }

    public void setDvisa(String dvisa) {
        this.dvisa = dvisa;
    }
    
    public String getDtravail() {
        return this.dtravail;
    }

    public void setDtravail(String dtravail) {
        this.dtravail = dtravail;
    }
    
    //

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return this.birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getContractStart() {
        return this.contractStart;
    }

    public void setContractStart(String contractStart) {
        this.contractStart = contractStart;
    }

    public String getContractEnd() {
        return this.contractEnd;
    }

    public void setContractEnd(String contractEnd) {
        this.contractEnd = contractEnd;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Set<Vacation> getVacations() {
        return this.vacations;
    }

    public void setVacations(Set<Vacation> vacations) {
        this.vacations = vacations;
    }

    public Set<Absense> getAbsenses() {
        return this.absenses;
    }

    public void setAbsenses(Set<Absense> absenses) {
        this.absenses = absenses;
    }
    
    
    //
    
    public Set<Paiment> getPaiments() {
        return this.paiments;
    }

    public void setPaiments(Set<Paiment> paiments) {
        this.paiments = paiments;
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
    
    //
    
    /*public MultipartFile getUserImage() {
		return userImage;
	}
	public void setUserImage(MultipartFile userImage) {
		this.userImage = userImage;
	}
	//*/
    
    
    

}
