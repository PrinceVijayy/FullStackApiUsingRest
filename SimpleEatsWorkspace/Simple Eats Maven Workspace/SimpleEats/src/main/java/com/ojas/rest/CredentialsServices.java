package com.ojas.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ojas.dao.credentials.CredentialsDAO;
import com.ojas.dao.credentials.CredentialsDAOImpl;
import com.ojas.model.Credentials;
import com.ojas.utils.UniqueRandomNumber;

@Path("/credentials")
public class CredentialsServices {
	
	CredentialsDAO dao=new CredentialsDAOImpl();
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Credentials> getAllCredentials() {
		return dao.getAllCredentials();
	}

	@GET
	@Path("/view/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Credentials getCredentialsById(@PathParam("id") int id) {
		return dao.getCredentialsById(id);
	}

	@POST
	@Path("/create/{id}/{username}/{password}/{type}")
	public String createProduct(@PathParam("id") int id, @PathParam("username") String username,
			@PathParam("password") String password,int token, @PathParam("type") String type) {
		token=UniqueRandomNumber.getUniqueRandomNumber();
		System.out.println(token);
		Credentials credentials=new Credentials(id,username,password,token, type);
		dao.createCredentials(credentials);
		return "Product added successfully " + id;

	}
	
	@PUT
	@Path("/create/{id}/{username}/{password}/{type}")
	public String updateCredentials(@PathParam("id") int id, @PathParam("username") String username,
			@PathParam("password") String password,int token, @PathParam("type") String type) {
		Credentials credentials=new Credentials(id,username,password,token, type);
		dao.updateCredentials(id,credentials);
		return "Product added successfully " + id;

	}
	
	@DELETE
	@Path("/delete/{id}")
	public String deleteCredentials(@PathParam("id") int id) {
		return dao.deleteCredentials(id);
	}

}
