package es.uv.isw.app6.beans;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Item> orders = new ArrayList<>();
	
	public void addOrder(Item order) {
		orders.add(order);
	}
	
	public ArrayList<Item> getOrders() {
		return orders;
	}
	
	@Override
	public String toString() {
		StringBuffer p = new StringBuffer();
		for (Item order : orders) {
			p.append(order + "\n");
		}
		return p.toString();
	}
}
