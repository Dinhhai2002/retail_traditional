package vn.aloapp.training.springboot.request;


import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CRUDWarehouseSessionDetailRequest {
	
	@Min(value=0, message="material_id nhỏ nhất là 0")
	@Max(value=1000000000, message="material_id lớn nhất là 1.000.000.000")
	@JsonProperty("material_id")
	private int materialId;
	
	@Min(value=0, message="quantity nhỏ nhất là 0")
	@Max(value=5000, message="quantity lớn nhất là 5.000")
	private BigDecimal quantity;

	
	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	
	
}
