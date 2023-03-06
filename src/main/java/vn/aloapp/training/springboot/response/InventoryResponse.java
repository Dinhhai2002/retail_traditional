package vn.aloapp.training.springboot.response;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.Inventory;

public class InventoryResponse {
	
	
private int id;
	
	private String name;
	
	@JsonProperty("total_quantity")
	private double totalQuantity;
	
	@JsonProperty("wastage_rate")
	private BigDecimal wastageRate;
	
	@JsonProperty("retail_price")
	private BigDecimal retailPrice;
	
	@JsonProperty("cost_price")
	private BigDecimal costPrice;
	
	
	public InventoryResponse() {
	}
	
	
	public InventoryResponse (Inventory entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.totalQuantity = entity.getTotalQuantity();
		this.wastageRate = entity.getWastageRate();
		this.costPrice = entity.getCostPrice();
		this.retailPrice = entity.getRetailPrice();
	}
	
	
	public List<InventoryResponse> mapToList(List<Inventory> entities) {
		return entities.stream().map(x -> new InventoryResponse(x)).collect(Collectors.toList());
	}

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
