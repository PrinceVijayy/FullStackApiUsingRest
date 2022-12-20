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

import com.ojas.dao.item.ItemDAO;
import com.ojas.dao.item.ItemDAOImpl;
import com.ojas.model.Item;

@Path("/item")
public class ItemServices {
	ItemDAO dao = new ItemDAOImpl();

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> viewAllItems() {
		return dao.viewAllItems();
	}

	@GET
	@Path("/view/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Item viewItem(@PathParam("id") int id) {
		return dao.viewItem(id);
	}

	@POST
	@Path("/create/{id}/{name}/{image}/{price}/{quantity}/{rating}")
	public String createItem(@PathParam("id") int id, @PathParam("name") String name, @PathParam("image") String image,
			@PathParam("price") double price, @PathParam("quantity") int quantity, @PathParam("rating") float rating) {
		Item item = new Item(id, name, image, price, quantity, rating);
		return dao.createItem(item);
	}

	@PUT
	@Path("/update/{id}/{name}/{image}/{price}/{quantity}/{rating}")
	public String updateItem(@PathParam("id") int id, @PathParam("name") String name, @PathParam("image") String image,
			@PathParam("price") double price, @PathParam("quantity") int quantity, @PathParam("rating") float rating) {
		Item item = new Item(id, name, image, price, quantity, rating);
		return dao.updateItem(id, item);
	}

	@DELETE
	@Path("/delete/{id}")
	public String deleteItem(@PathParam("id") int id) {
		return dao.deleteItem(id);
	}
}
