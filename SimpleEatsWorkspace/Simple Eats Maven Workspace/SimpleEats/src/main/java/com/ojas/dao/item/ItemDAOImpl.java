package com.ojas.dao.item;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ojas.model.Item;
import com.ojas.utils.SessionConfiguration;

public class ItemDAOImpl implements ItemDAO {

	// see this to know how the session configuration implemented
	SessionConfiguration sc;
	int n = 0;
	String message;

	public List<Item> viewAllItems() {
		Session session=sc.getSessionFactory().openSession();

		// write your Logic

		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		Query query = session.createQuery("from Item");
		List<Item> li = query.list();

		// End transaction

		transaction.commit();

		session.close();

		sc.getSessionFactory().close();
		return li;
	}

	public Item viewItem(int id) {
		Session session = sc.getSessionFactory().openSession();

		// write your Logic
		Item item = session.get(Item.class, id);

		session.close();

		sc.getSessionFactory().close();
		return item;
	}

	public String createItem(Item item) {
		Session session = sc.getSessionFactory().openSession();

		// write your Logic
		Item newItem = session.get(Item.class, item.getId());

		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		if (newItem == null) {
			session.save(item);
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

	public String updateItem(int id, Item item) {
		Session session = sc.getSessionFactory().openSession();

		// write your Logic
		Item newItem = session.get(Item.class, id);

		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		if (newItem != null) {
			newItem.setName(item.getName());
			newItem.setPrice(item.getPrice());
			newItem.setQuantity(item.getQuantity());
			newItem.setRating(item.getRating());
			newItem.setImage(item.getImage());
			session.update(newItem);
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

	public String deleteItem(int id) {
		Session session = sc.getSessionFactory().openSession();

		// write your Logic
		Item item = session.get(Item.class, id);
		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		if (item != null) {
			session.delete(item);
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
