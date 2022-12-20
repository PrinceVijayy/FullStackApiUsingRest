package com.ojas.dao.credentials;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ojas.model.Credentials;
import com.ojas.utils.SessionConfiguration;

public class CredentialsDAOImpl implements CredentialsDAO {
	// see this to know how the session configuration implemented
	SessionConfiguration sc;
	int n = 0;
	String message;

	public List<Credentials> getAllCredentials() {
		Session session = sc.getSessionFactory().openSession();

		// write your Logic

		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		Query query = session.createQuery("from Credentials");

		List<Credentials> li = query.list();

		// End transaction

		transaction.commit();

		session.close();

		sc.getSessionFactory().close();
		return li;
	}

	@Override
	public Credentials getCredentialsById(int id) {
		Session session = sc.getSessionFactory().openSession();

		// write your Logic
		Credentials credentials = session.get(Credentials.class, id);

		session.close();

		sc.getSessionFactory().close();
		return credentials;
	}

	@Override
	public String createCredentials(Credentials credentials) {
		Session session = sc.getSessionFactory().openSession();

		// write your Logic
		Credentials newCredentials = session.get(Credentials.class, credentials.getId());

		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		if (newCredentials == null) {
			session.save(credentials);
			message = "Bus Successfully created";
		} else {
			message = "Something went wrong";
		}

		// End transaction

		transaction.commit();

		session.close();

		sc.getSessionFactory().close();
		return message;
	}

	@Override
	public String updateCredentials(int id, Credentials credentials) {
		Session session = sc.getSessionFactory().openSession();

		// write your Logic
		Credentials newCredentials = session.get(Credentials.class, id);

		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		if (newCredentials != null) {
			newCredentials.setId(credentials.getId());
			newCredentials.setUsername(credentials.getUsername());
			newCredentials.setPassword(credentials.getPassword());
			newCredentials.setType(credentials.getType());
			newCredentials.setToken(credentials.getToken());
			session.update(newCredentials);
			message = "Bus Successfully updated";
		} else {
			message = "Something went wrong";
		}

		// End transaction

		transaction.commit();

		session.close();

		sc.getSessionFactory().close();
		return message;
	}

	@Override
	public String deleteCredentials(int id) {
		Session session = sc.getSessionFactory().openSession();

		// write your Logic
		Credentials credentials = session.get(Credentials.class, id);
		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		if (credentials != null) {
			session.delete(credentials);
			message = "Bus Successfully deleted";
		} else {
			message = "Something went wrong";
		}

		// End transaction

		transaction.commit();
		session.close();

		sc.getSessionFactory().close();
		return message;
	}

}
