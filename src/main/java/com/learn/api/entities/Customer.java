package com.learn.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Table(name = "p_customer")
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Customer extends BaseEntity {
	private static final long serialVersionUID = 2253247248225808312L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "notes", columnDefinition="text")
	private String notes;
}
