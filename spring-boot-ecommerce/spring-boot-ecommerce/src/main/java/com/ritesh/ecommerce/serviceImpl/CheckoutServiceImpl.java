package com.ritesh.ecommerce.serviceImpl;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ritesh.ecommerce.dto.Purchase;
import com.ritesh.ecommerce.dto.PurchaseResponse;
import com.ritesh.ecommerce.entities.Address;
import com.ritesh.ecommerce.entities.Customer;
import com.ritesh.ecommerce.entities.Order;
import com.ritesh.ecommerce.entities.OrderItem;
import com.ritesh.ecommerce.repositories.CustomerRepository;
import com.ritesh.ecommerce.services.CheckoutService;

import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	private CustomerRepository customerRepository;
	
	public CheckoutServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository=customerRepository;
	}
	
	
	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {
		// TODO Auto-generated method stub
		
		//retrieve the order from the dto
	     Order order = purchase.getOrder();
		
		//generate tracking number
		String orderTrackingNumber=generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);
	     
		//populate order with order items
		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item->order.add(item));
		
		//populate order with billing and shipping address
		Address shippingAddress=purchase.getShippingAddress();
		Address billingAddress=purchase.getBillingAddress();
		order.setShippingAddress(shippingAddress);
		order.setBillingAddress(billingAddress);
		
		//populate customer with order
		Customer customer=purchase.getCustomer();
		String email = customer.getEmail();
		Customer customer2 = this.customerRepository.findByEmail(email);
		if(customer2!=null) {
			customer=customer2;
		}
		
		customer.add(order);
		
		//save to the database
		customerRepository.save(customer);
		
		//return a response
		return new PurchaseResponse(orderTrackingNumber);
	}


	private String generateOrderTrackingNumber() {
		
		return UUID.randomUUID().toString();
	}

}
