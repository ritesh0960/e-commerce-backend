package com.ritesh.ecommerce.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.core.sym.Name;

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
@Table(name="product")
@Setter
@Getter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;
	@Column(name = "sku")
    private String sku;
	@Column(name = "name")
    private String name;
	@Column(name = "description")
    private String description;
	@Column(name = "unit_price")
    private Double unitprice;
	@Column(name = "image_url")
    private String imageUrl;
	@Column(name = "active")
    private Boolean active;
	@Column(name = "units_in_stock")
    private Integer unitsInStock;
	@Column(name = "date_created")
	@CreationTimestamp
    private Date dateCreated;
	@Column(name = "last_updated")
	@UpdateTimestamp
    private Date lastUpdated;
	
	@ManyToOne
	@JoinColumn(name = "category_id",nullable = false)
	private productCategory category;
}
