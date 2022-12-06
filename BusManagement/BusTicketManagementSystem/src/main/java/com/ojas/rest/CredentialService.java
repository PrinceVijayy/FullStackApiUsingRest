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

import com.ojas.dao.CredentialDAO;
import com.ojas.dao.CredentialDAOImpl;
import com.ojas.model.Credential;

@Path("/credential")
public class CredentialService {
		CredentialDAO dao=new CredentialDAOImpl();
		
		@POST
		@Path("/create/{type}/{firstName}/{lastName}/{username}/{email}/{password}")
		public String createCredential(@PathParam("type")String type,@PathParam("firstName")String firstName,@PathParam("lastName") String lastName,@PathParam("username")String username,@PathParam("email")String email,@PathParam("password")String password) {
			Credential cred=new Credential(type, firstName, lastName, username, email, password);
			return dao.createCredentials(cred);
		}
		@PUT
		@Path("/update/{id}/{type}/{firstName}/{lastName}/{username}/{email}/{password}")
		public String createCredential(@PathParam("id")int id,@PathParam("type")String type,@PathParam("firstName") String firstName,@PathParam("lastName") String lastName,@PathParam("username") String username,@PathParam("email") String email,@PathParam("password") String password) {
			Credential cred=new Credential(type, firstName, lastName, username, email, password);
			return dao.updateCredentials(id,cred);
		}
		
		@DELETE
		@Path("delete/{id}")
		public String deleteCredential(@PathParam("id") int id) {
			return dao.deleteCredentials(id);
		}
		
		@GET
		@Path("view/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Credential viewCredential(@PathParam("id") int id) {
			return dao.viewCredential(id);
		}
		@GET
		@Path("/list")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Credential> viewAllCredentials(){
			return dao.viewAllCredentials();
		}
}
