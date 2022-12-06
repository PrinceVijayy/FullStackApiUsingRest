package com.ojas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bus {

	@Id
	@Column(name = "id")
	public int busId;
	@Column(name = "name")
	public String busName;
	@Column(name = "seats")
	public int busSeats;

}
