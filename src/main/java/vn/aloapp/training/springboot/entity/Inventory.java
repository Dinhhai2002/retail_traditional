package vn.aloapp.training.springboot.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Inventory {
	
	@Id
	private int id;
	
	private String name;
	
	@Column(name = "total_quantity")
	private double totalQuantity;
	
	@Column(name = "wastage_rate")
	private BigDecimal wastageRate;
	
	@Column(name = "retail_price")
	private BigDecimal retailPrice;
	
	@Column(name = "cost_price")
	private BigDecimal costPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public BigDecimal getWastageRate() {
		return wastageRate;
	}

	public void setWastageRate(BigDecimal wastageRate) {
		this.wastageRate = wastageRate;
	}

	public BigDecimal getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	
	
	

}
