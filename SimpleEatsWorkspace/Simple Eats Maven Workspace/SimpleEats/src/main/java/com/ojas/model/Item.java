package com.ojas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ITEM")
public class Item {

	@Id
	private int id;
	private String name;
	private String image;
	private double price;
	private int quantity;
	private float rating;
	
}
