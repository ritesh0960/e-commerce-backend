package com.ritesh.ecommerce.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order_item")
@Setter
@Getter
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="image_url")
	private String imageUrl;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="product_id")
	private long productId;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
}
