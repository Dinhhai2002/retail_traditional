package vn.aloapp.training.springboot.request;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;


public class OrderDetailRequest {
	
	
	@Min(value = 1 , message = "material_id nhỏ nhất 1")
	@Max(value = 10000000 , message = "material_id lớn nhất 10.000.000")
	@JsonProperty("material_id")
	private int materialId;
	
	
	@Min(value = 1 , message = "materialId nhỏ nhất 1")
	@Max(value = 10000 , message = "materialId lớn nhất 1000")
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
