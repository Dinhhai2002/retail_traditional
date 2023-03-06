package vn.aloapp.training.springboot.request;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CRUDWarehouseSessionRequest {
	
	
	@Min(value = 0 , message = "nhỏ nhất là 0.")
	@Max(value = 100, message = "lớn nhất 100.")
	@JsonProperty("discount_percent")
	private double discountPercent;
	
	@Min(value = 0 , message = "vat nhỏ nhất là 0.")
	@Max(value = 100, message = "vat lớn nhất 100.")
	private double vat;
	
	@Min(value = 0, message = "discount_amount nhỏ nhất là 0")
	@JsonProperty("discount_amount")
	private double discountAmount;
	

	@NotNull(message = "description không được phép null")
	@Length(max = 255, message = "description Không được phép lớn hơn 255 kí tự")
	private String description;	
	
	@JsonProperty("warehouse_session_details")
	private List<CRUDWarehouseSessionDetailRequest> warehouseSessionDetails;


	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CRUDWarehouseSessionDetailRequest> getWarehouseSessionDetails() {
		return warehouseSessionDetails;
	}

	public void setWarehouseSessionDetails(List<CRUDWarehouseSessionDetailRequest> warehouseSessionDetails) {
		this.warehouseSessionDetails = warehouseSessionDetails;
	}

	
	
	
}