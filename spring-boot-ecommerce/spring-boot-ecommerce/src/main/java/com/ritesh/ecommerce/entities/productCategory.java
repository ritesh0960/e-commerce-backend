package com.ritesh.ecommerce.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category")
@Setter
@Getter
public class productCategory {
	       @Id
	       @GeneratedValue(strategy = GenerationType.IDENTITY)
	       @Column(name = "id")
           private Integer id;
	       @Column(name = "category_name")
           private String categoryName;
	       
	       @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	       private Set<Product> products;
}
