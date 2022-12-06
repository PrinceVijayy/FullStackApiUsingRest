package com.ojas.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ojas.model.Bus;

public class BusDAOImpl implements BusDAO {
	int n = 0;
	String message;

	public String createBus(Bus bus) {
		// Configuration start
		Configuration configure = new Configuration();

		configure.configure();

		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// write your Logic
		Bus newBus = session.get(Bus.class, bus.busId);
//		System.out.println(newBus.busId);
//		System.out.println(newBus.busName);
//		System.out.println(newBus.busSeats);
		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		if (newBus == null) {
			session.save(bus);
			message = "Bus Successfully created";
		} else {
			message = "Something went wrong";
		}
//		Query query = session.createQuery("insert into Bus(busId, busName, busSeats) values=(?,?,?)");		query.setParameter(1,bus.getBusId());
//		query.setParameter(0, bus.getBusId());
//		query.setParameter(1, bus.getBusName());
//		query.setParameter(2, bus.getBusSeats());
//		n=query.executeUpdate();
//		
//		if (n != 0) {
//			
//			message = "Bus Successfully created";
//		}else {
//			message = "Something went wrong";
//		}
// 
		// End transaction

		transaction.commit();

		session.close();

		sessionFactory.close();
		return message;
	}

	public String updateBus(int busId, String busName, int busSeats) {
		// Configuration start

		Configuration configure = new Configuration();

		configure.configure();

		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// write your Logic
		Bus newBus = session.get(Bus.class, busId);

		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		if (newBus != null) {
			newBus.setBusName(busName);
			newBus.setBusSeats(busSeats);
			session.update(newBus);
			message = "Bus Successfully updated";
		} else {
			message = "Something went wrong";
		}

		// End transaction

		transaction.commit();

		session.close();

		sessionFactory.close();
		return message;
	}

	public String deleteBus(int busId) {
		// Configuration start

		Configuration configure = new Configuration();

		configure.configure();

		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// write your Logic
		Bus bus = session.get(Bus.class, busId);
		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		if (bus != null) {
			session.delete(bus);
			message = "Bus Successfully deleted";
		} else {
			message = "Something went wrong";
		}

		// End transaction

		transaction.commit();
		session.close();

		sessionFactory.close();
		return message;
	}

	public Bus viewBus(int busId) {
		// Configuration start

		Configuration configure = new Configuration();

		configure.configure();

		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// write your Logic
		Bus bus = session.get(Bus.class, busId);

		session.close();

		sessionFactory.close();
		return bus;
	}


	public List<Bus> viewAllBuses() {
		// Configuration start

		Configuration configure = new Configuration();

		configure.configure();

		SessionFactory sessionFactory = configure.buildSessionFactory();

		Session session = sessionFactory.openSession();

		// write your Logic

		// Begin transaction

		Transaction transaction = session.beginTransaction();

		// write operations like save/update/delete/query
		Query query = session.createQuery("from Bus");
		List<Bus> li = query.list();

		// End transaction

		transaction.commit();

		session.close();

		sessionFactory.close();
		return li;
	}

}
