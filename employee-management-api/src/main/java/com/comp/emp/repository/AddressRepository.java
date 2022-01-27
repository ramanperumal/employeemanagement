/*
 * 
 */
package com.comp.emp.repository;

import org.springframework.stereotype.Repository;

import com.comp.emp.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface AddressRepository.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	/**
	 * Find by empid.
	 *
	 * @param empid the empid
	 * @return the address
	 */
	Address findByEmpid(Integer empid);

}
