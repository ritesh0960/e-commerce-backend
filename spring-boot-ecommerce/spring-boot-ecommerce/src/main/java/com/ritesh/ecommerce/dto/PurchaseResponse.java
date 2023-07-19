package com.ritesh.ecommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseResponse {
    
	private String orderTrackingNumber;
	
	public PurchaseResponse(String orderTrackingNumber) {
		// TODO Auto-generated constructor stub
		this.orderTrackingNumber=orderTrackingNumber;
	}

	
	
}
