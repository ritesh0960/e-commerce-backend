package com.ritesh.ecommerce.services;

import com.ritesh.ecommerce.dto.Purchase;
import com.ritesh.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);

}
