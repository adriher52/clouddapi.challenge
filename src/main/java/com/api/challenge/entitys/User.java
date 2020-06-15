package com.api.challenge.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
//@Table(name = "users")
public class User {

	@Id
	//@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	//@Column(name = "name", nullable = false)
	private String name;

	//@Column(name = "email", nullable = false)
	private String email;

	//@Column(name = "birthDate", nullable = false)
	private String birthDate;
 
	//@Embedded
	//@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ADDRESS_Id")),
		//    @AttributeOverride(name = "street", column = @Column(name = "ADDRESS_Street")),
			//@AttributeOverride(name = "state", column = @Column(name = "ADDRESS_State")),
			//@AttributeOverride(name = "city", column = @Column(name = "ADDRESS_City")),
			//@AttributeOverride(name = "country", column = @Column(name = "ADDRESS_Country")),
			//@AttributeOverride(name = "zipcode", column = @Column(name = "ADDRESS_Zipcode")) })
	@OneToOne(cascade = CascadeType.ALL)
	private AddressId address;

	public User() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public AddressId getAddress() {
		return address;
	}

	public void setAddress(AddressId address) {
		this.address = address;
	}
	
	
}
