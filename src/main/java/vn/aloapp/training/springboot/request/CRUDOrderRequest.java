package vn.aloapp.training.springboot.request;



import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CRUDOrderRequest {	
	
	@Min(value = 0,message="vat nhỏ nhất là 0%")
	@Max(value = 100,message="vat lớn nhất là 100%")
	private double vat;
	
	
	@Min(value = 0,message="discount_percent nhỏ nhất là 0%")
	@Max(value = 100,message="discount_percent lớn nhất là 100%")
	@JsonProperty("discount_percent")
	private double discountPercent;
	
	@Min(value = 0,message="discount_amount nhỏ nhất là 0")
	@Max(value = 10000000,message="discount_amount lớn nhất là 10.000.000")
	@JsonProperty("discount_amount")
	private double discountAmount;
	
	@NotNull(message = "description tên không được phép null")
	@Length(max = 255, message = "không vượt quá 255 kí tự")
	private String description;
	
	@Valid
	@JsonProperty("order_details")
	private List<OrderDetailRequest> orderDetails;


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
