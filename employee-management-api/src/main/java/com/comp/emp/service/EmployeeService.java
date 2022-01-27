/*
 * 
 */
package com.comp.emp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comp.emp.domain.Address;
import com.comp.emp.domain.AddressDTO;
import com.comp.emp.domain.Employee;
import com.comp.emp.domain.EmployeeDTO;
import com.comp.emp.exception.ConflictException;
import com.comp.emp.exception.ResourceNotFoundException;
import com.comp.emp.repository.AddressRepository;
import com.comp.emp.repository.EmployeeRepository;
import com.comp.emp.transformer.ObjectDTOTransformer;

/**
 * The Class EmployeeService.
 */
@Service
public class EmployeeService {

	/** The employee repository. */
	@Autowired
	EmployeeRepository employeeRepository;

	/** The addressrepository. */
	@Autowired
	AddressRepository addressrepository;

	/**
	 * Creates the employee.
	 *
	 * @param employeeDTO the employee DTO
	 * @return the employee DTO
	 */
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

		Employee employeeOrig = employeeRepository.findByEmail(employeeDTO.getEmail());

		if (employeeOrig != null) {
			throw new ConflictException("Employee with same emailid already exists");
		}

		Employee lEmployee = new Employee();
		lEmployee.setName(employeeDTO.getName());
		lEmployee.setGender(employeeDTO.getGender());
		lEmployee.setEmail(employeeDTO.getEmail());
		lEmployee.setContact(employeeDTO.getContact());

		Employee employee = employeeRepository.save(lEmployee);

		if (employeeDTO.getAddress() != null) {
			Address address = new Address();
			address.setEmpid(employee.getId());
			address.setStreet(employeeDTO.getAddress().getStreet());
			address.setCity(employeeDTO.getAddress().getCity());
			address.setState(employeeDTO.getAddress().getState());
			address.setZip(employeeDTO.getAddress().getZip());
			addressrepository.save(address);
		}

		return employeeToDTO(employee);
	}

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		if(employees.isEmpty()) {
			throw new ResourceNotFoundException("There are no employees to display");
		}
		return employees.stream().map(s-> employeeToDTO(s)).collect(Collectors.toList());
	}

	/**
	 * Gets the employee.
	 *
	 * @param employeeId the employee id
	 * @return the employee
	 */
	public EmployeeDTO getEmployee(Integer employeeId) {

		Optional<Employee> employeeOrig = employeeRepository.findById(employeeId);

		if (!employeeOrig.isPresent()) {
			throw new ResourceNotFoundException("Employee deosn't exists for this Id.");
		}
		
		Employee employee = employeeRepository.findById(employeeId).get();
		return employeeToDTO(employee);
	}

	/**
	 * Update employee.
	 *
	 * @param employeeDTO the employee DTO
	 * @return the employee DTO
	 */
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		Employee employee = employeeRepository.findById(employeeDTO.getId()).get();

		employee.setName(employeeDTO.getName());
		employee.setGender(employeeDTO.getGender());
		employee.setEmail(employeeDTO.getEmail());
		employee.setContact(employeeDTO.getContact());

		employeeRepository.save(employee);
		
		Address address = addressrepository.findByEmpid(employeeDTO.getId());
		address.setEmpid(employee.getId());
		address.setStreet(employeeDTO.getAddress().getStreet());
		address.setCity(employeeDTO.getAddress().getCity());
		address.setState(employeeDTO.getAddress().getState());
		address.setZip(employeeDTO.getAddress().getZip());
		addressrepository.save(address);
		
		return employeeDTO;

	}

	/**
	 * Delete employee.
	 *
	 * @param empId the emp id
	 */
	public void deleteEmployee(Integer empId) {

		Optional<Employee> employeeOrig = employeeRepository.findById(empId);

		if (!employeeOrig.isPresent()) {
			throw new ResourceNotFoundException("Employee deosn't exists for this Id.");
		} else {
			employeeRepository.deleteById(empId);
		}
	}
	
	/**
	 * Employee to DTO.
	 *
	 * @param employee the employee
	 * @return the employee DTO
	 */
	private EmployeeDTO  employeeToDTO(Employee employee) {
		Address address = addressrepository.findByEmpid(employee.getId());
		AddressDTO addressDTO = ObjectDTOTransformer.addressToDTO(address);
		return ObjectDTOTransformer.employeeToDTO(employee, addressDTO);
	}
}
