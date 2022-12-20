package com.ojas.dao.item;

import java.util.List;

import com.ojas.model.Item;

public interface ItemDAO {

	public List<Item> viewAllItems();

	public Item viewItem(int id);

	public String createItem(Item item);

	public String updateItem(int id, Item item);

	public String deleteItem(int id);
}
