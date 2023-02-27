package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OrderDetailRequest {
	
	
	@Min(value = 0 , message = "nhỏ nhất 0")
	@Max(value = 10000000 , message = "lớn nhất 10.000.000")
	@JsonProperty("material_id")
	private int material_id;
	
	
	@Min(value = 0 , message = "nhỏ nhất 0")
	@Max(value = 10000 , message = "lớn nhất 1000")
	private int quantity;

	

	public int getMaterial_id() {
		return material_id;
	}

	public void setMaterial_id(int material_id) {
		this.material_id = material_id;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
}
