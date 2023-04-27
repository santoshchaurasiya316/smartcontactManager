package com.API.Login.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
@Table(name = "mobile")
public class MobileNo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mobileId;
	private long  mobileNumber;
	@Column(name = "SIM")
	private String sim;
	
	@JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private UserLogin login;
}
