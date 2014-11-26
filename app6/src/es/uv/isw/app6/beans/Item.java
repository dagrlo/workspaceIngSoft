package es.uv.isw.app6.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
	private Date date = new Date();
	private String product = "";
	private int quantity = 0;
		
	public Item(Date date, String product, int quantity) {
		this.date = date;
		this.product = product;
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String stringDate = dateFormat.format(date);
		return "[" + stringDate + "] " + product + " (" + quantity + ")";
	}
	
}
