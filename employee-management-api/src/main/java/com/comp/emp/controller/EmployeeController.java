/*
 * 
 */
package com.comp.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comp.emp.domain.EmployeeDTO;
import com.comp.emp.service.EmployeeService;

/**
 * The Class EmployeeController.
 */
@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	/** The employee service. */
	@Autowired
	private EmployeeService employeeService;
    
    /**
     * Creates the employee.
     *
     * @param employee the employee
     * @return the employee DTO
     */
    @PostMapping
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee) { 
    	return employeeService.createEmployee(employee);
	}
    
    /**
     * Gets the all employees.
     *
     * @return the all employees
     */
    @GetMapping
	public List<EmployeeDTO> getAllEmployees() { 
    	return employeeService.getAllEmployees();
	}
    
    /**
     * Gets the employee.
     *
     * @param id the id
     * @return the employee
     */
    @GetMapping(value="/{id}")
	public EmployeeDTO getEmployee(@PathVariable Integer id) { 
    	return employeeService.getEmployee(id);
	}
    
    /**
     * Update employee.
     *
     * @param pEmployee the employee
     * @return the employee DTO
     */
    @PutMapping
	public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO pEmployee) { 
    	return employeeService.updateEmployee(pEmployee);
	}
    
    /**
     * Delete employee.
     *
     * @param id the id
     */
    @DeleteMapping(value="/{id}")
	public void deleteEmployee(@PathVariable Integer id) { 
    	employeeService.deleteEmployee(id);
	}
}

