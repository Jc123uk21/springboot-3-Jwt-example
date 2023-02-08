package com.jCatchpole.CoffeesToGo.Model;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
 public class Store {
	//Attributes
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long id;
		
	@NonNull
	@Size(max = 50, min = 15, message = "address must be between 15 and 50 characters in length!")
	private String address;
		
	@NonNull
	@Email
	private String email;
		
	@NonNull
	@Size(max = 11, min = 11, message = "contact number must be 11 digits long")
	private String contactNumber;
	
	//Constructors
	
	public Store() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", address=" + address + ", email=" + email + ", contactNumber=" + contactNumber
				+ "]";
	}
	
	
}
