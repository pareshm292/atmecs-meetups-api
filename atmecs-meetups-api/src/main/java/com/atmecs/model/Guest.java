package com.atmecs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="guests")
public class Guest {

	
	@Id
	@GeneratedValue
	private Integer guestId;
	
	@Email
	@NotNull
	private String email;
	
	@NotNull
	private String name;
	
	@NotNull
	@JsonIgnore
	private String password;
	
	
	@NotNull
	private String companyName;
	
	@NotNull
	private String companyAddress;
	
	@NotNull
	private String technicalSkills;
	
	@NotNull
	private Integer yearsofExperience;

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompanyName() {
		return companyName;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getTechnicalSkills() {
		return technicalSkills;
	}

	public void setTechnicalSkills(String technicalSkills) {
		this.technicalSkills = technicalSkills;
	}

	public Integer getYearsofExperience() {
		return yearsofExperience;
	}

	public void setYearsofExperience(Integer yearsofExperience) {
		this.yearsofExperience = yearsofExperience;
	}

	public Guest(String email, String password,String name, String companyName, String companyAddress, String technicalSkills,
			Integer yearsofExperience) {
		super();
		this.email = email;
		this.password = password;
		this.name =name;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.technicalSkills = technicalSkills;
		this.yearsofExperience = yearsofExperience;
	}

	public Guest() {
		super();
	}

	@Override
	public String toString() {
		return "Guest [guestId=" + guestId + ", email=" + email + ", password=" + password + ",name= "+ name + ", companyName="
				+ companyName + ", companyAddress=" + companyAddress + ", technicalSkills=" + technicalSkills
				+ ", yearsofExperience=" + yearsofExperience + "]";
	}
	

	
	

}
