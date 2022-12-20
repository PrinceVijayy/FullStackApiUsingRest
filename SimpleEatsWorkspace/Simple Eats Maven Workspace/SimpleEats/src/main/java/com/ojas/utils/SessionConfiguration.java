package com.ojas.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConfiguration {
	
	public static SessionFactory sFactory = null;

	public static SessionFactory getSessionFactory() {
		Configuration con = new Configuration();
		con.configure();
		sFactory = con.buildSessionFactory();
		return sFactory;
	}
}
