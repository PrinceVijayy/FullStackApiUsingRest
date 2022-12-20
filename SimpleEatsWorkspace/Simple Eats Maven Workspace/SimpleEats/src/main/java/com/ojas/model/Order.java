package com.ojas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ORDER")
public class Order {

	@Id
	private int id;
	@OneToOne
	private Customer customer;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Item> items = new ArrayList<>();
	private double bill;

}
