/*
 * 
 */
package com.comp.emp.domain;

/**
 * The Class EmployeeDTO.
 */
public class EmployeeDTO {
    
    /** The id. */
    private Integer id;
	
	/** The name. */
	private String name;
	
	/** The gender. */
	private String gender;
	
	/** The email. */
	private String email;
	
	/** The contact. */
	private Long contact;
	
	/** The address. */
	private AddressDTO address;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public Long getContact() {
		return contact;
	}
	
	/**
	 * Sets the contact.
	 *
	 * @param contact the new contact
	 */
	public void setContact(Long contact) {
		this.contact = contact;
	}
	
	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public AddressDTO getAddress() {
		return address;
	}
	
	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", contact="
				+ contact + ", address=" + address + "]";
	}
}
