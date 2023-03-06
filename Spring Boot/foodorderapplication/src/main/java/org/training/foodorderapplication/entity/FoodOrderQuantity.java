package org.training.foodorderapplication.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class FoodOrderQuantity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int foodOrderQuantityId;
	
	@ManyToOne
	@JoinColumn(name = "foodItemVendorId")
	private FoodItemVendor foodItemVendor;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private FoodOrder foodOrder;
	
	private int quantity;
	
}
