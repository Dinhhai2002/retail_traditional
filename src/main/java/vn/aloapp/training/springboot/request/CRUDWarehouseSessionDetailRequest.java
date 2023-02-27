package vn.aloapp.training.springboot.request;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CRUDWarehouseSessionDetailRequest {
	
	@Min(value=0, message="nhỏ nhất là 0")
	@Max(value=1000000000, message="lớn nhất là 1.000.000.000")
	@JsonProperty("material_id")
	private int materialId;
	
	@Min(value=0, message="nhỏ nhất là 0")
	@Max(value=5000, message="lớn nhất là 5.000")
	private int quantity;

	
	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
