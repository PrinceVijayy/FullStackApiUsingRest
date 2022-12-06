package com.ojas.dao;

import java.util.List;

import com.ojas.model.Credential;

public interface CredentialDAO {
	
	public String createCredentials(Credential credential);
	public String updateCredentials(int id, Credential credential);
	public String deleteCredentials(int id);
	public Credential viewCredential(int id);
	public List<Credential> viewAllCredentials();
}
