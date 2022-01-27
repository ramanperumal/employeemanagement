/*
 * 
 */
package com.comp.emp.transformer;

import com.comp.emp.domain.Address;
import com.comp.emp.domain.AddressDTO;
import com.comp.emp.domain.Employee;
import com.comp.emp.domain.EmployeeDTO;

/**
 * The Class ObjectDTOTransformer.
 */
public class ObjectDTOTransformer {

	/**
	 * Employee to DTO.
	 *
	 * @param employee the employee
	 * @param address the address
	 * @return the employee DTO
	 */
	public static EmployeeDTO employeeToDTO(Employee employee, AddressDTO address) {

		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(employee.getId());
		dto.setName(employee.getName());
		dto.setGender(employee.getGender());
		dto.setEmail(employee.getEmail());
		dto.setContact(employee.getContact());
		dto.setAddress(address);
		return dto;
	}

	/**
	 * Address to DTO.
	 *
	 * @param address the address
	 * @return the address DTO
	 */
	public static AddressDTO addressToDTO(Address address) {

		AddressDTO dto = new AddressDTO();
		dto.setStreet(address.getStreet());
		dto.setCity(address.getCity());
		dto.setState(address.getState());
		dto.setZip(address.getZip());
		return dto;
	}
}
