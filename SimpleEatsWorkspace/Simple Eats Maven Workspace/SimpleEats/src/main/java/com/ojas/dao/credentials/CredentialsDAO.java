package com.ojas.dao.credentials;

import java.util.List;

import com.ojas.model.Credentials;

public interface CredentialsDAO {
	
	public List<Credentials> getAllCredentials() ;
	
	public Credentials getCredentialsById(int id);
	
	public String createCredentials(Credentials credentials);
	
	public String updateCredentials(int id, Credentials credentials);
	
	public String deleteCredentials(int id);

}
