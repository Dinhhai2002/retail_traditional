package vn.aloapp.training.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BestSellerModel {
	
	@Id
	private String date;
	private String name;
	private int quantity;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}
