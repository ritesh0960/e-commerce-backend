package com.ritesh.ecommerce.dto;

import java.util.Set;

import com.ritesh.ecommerce.entities.Address;
import com.ritesh.ecommerce.entities.Customer;
import com.ritesh.ecommerce.entities.Order;
import com.ritesh.ecommerce.entities.OrderItem;

import lombok.Data;

@Data
public class Purchase {
   
	private Customer customer;
	
	private Address shippingAddress;
	
	private Address billingAddress;
	
	private Order order;
	
	private Set<OrderItem> orderItems;
	
}
