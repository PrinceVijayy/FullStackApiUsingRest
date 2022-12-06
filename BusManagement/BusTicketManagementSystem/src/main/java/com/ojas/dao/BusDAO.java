package com.ojas.dao;

import java.util.List;

import com.ojas.model.Bus;

public interface BusDAO {

	public String createBus(Bus bus);

	public String updateBus(int busId, String busName,int busSeats);

	public String deleteBus(int busId);

	public Bus viewBus(int busId);

	public List<Bus> viewAllBuses();

}
