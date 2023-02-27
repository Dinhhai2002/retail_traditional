package vn.aloapp.training.springboot.request;



import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CRUDOrderRequest {
	
	@Min(value = 0 , message = "nhỏ nhất 0.")
	@JsonProperty("user_id")
	private int userId;
	
	@Min(value = 0,message="nhỏ nhất là 0%")
	@Max(value = 100,message="lớn nhất là 100%")
	private double vat;
	
	
	@Min(value = 0,message="nhỏ nhất là 0%")
	@Max(value = 100,message="lớn nhất là 100%")
	@JsonProperty("discount_percent")
	private double discountPercent;
	
	@Min(value = 0,message="nhỏ nhất là 0")
	@Max(value = 10000000,message="lớn nhất là 10.000.000")
	@JsonProperty("discount_amount")
	private double discountAmount;
	
	
	@Length(max = 255, message = "không vượt quá 255 kí tự")
	private String description;
	
	@Valid
	@JsonProperty("order_details")
	private List<OrderDetailRequest> orderDetails;

	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
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

	public List<OrderDetailRequest> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailRequest> orderDetails) {
		this.orderDetails = orderDetails;
	}


}
