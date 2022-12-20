package com.ojas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
	
	@Id
	private int id;
	private String username;
	private String password;
	private int token;
	private String type;
	
   
}
