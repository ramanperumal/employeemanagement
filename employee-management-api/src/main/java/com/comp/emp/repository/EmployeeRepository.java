/*
 * 
 */
package com.comp.emp.repository;

import org.springframework.stereotype.Repository;

import com.comp.emp.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The Interface EmployeeRepository.
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	/**
	 * Find by name.
	 *
	 * @param name the name
	 * @return the employee
	 */
	Employee findByName(String name);
	
	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return the employee
	 */
	Employee findByEmail(String email);

}
