package com.ojas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	private int id;
	private String name;
	private String email;
	private long mobile;
	private double walletBalance;

	@OneToOne
	private Order order;
	
	@OneToOne
	private OrderHistory orderHistory;

}
