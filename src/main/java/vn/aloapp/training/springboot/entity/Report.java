package vn.aloapp.training.springboot.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Report {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	private String date;
	
	private BigDecimal amountImport;
	private BigDecimal amountExport;
	private BigDecimal profit;
	private BigDecimal inventory;
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getAmountImport() {
		return amountImport;
	}
	public void setAmountImport(BigDecimal amountImport) {
		this.amountImport = amountImport;
	}
	public BigDecimal getAmountExport() {
		return amountExport;
	}
	public void setAmountExport(BigDecimal amountExport) {
		this.amountExport = amountExport;
	}
	public BigDecimal getProfit() {
		return profit;
	}
	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}
	public BigDecimal getInventory() {
		return inventory;
	}
	public void setInventory(BigDecimal inventory) {
		this.inventory = inventory;
	}
	
	
	
}
