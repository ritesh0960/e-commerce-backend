package com.ritesh.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.ecommerce.dto.Purchase;
import com.ritesh.ecommerce.dto.PurchaseResponse;
import com.ritesh.ecommerce.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
   
	  Customer findByEmail(String theEmail);
}
