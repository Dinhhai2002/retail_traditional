package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDMaterialRequest extends BaseRequest{

	
	@NotEmpty(message = "name không được phép để trống")
	@Length(max = 255, message = "name không được phép lớn hơn 255 kí tự")
	private String name;

	@Min(value = 0, message = "category_id nhỏ nhất 0")
	@JsonProperty("category_id")
	private int categoryId;

	@Min(value = 0, message = "unit_id nhỏ nhất 0")
	@JsonProperty("unit_id")
	private int unitId;

	@Min(value = 0 , message = "wastage_rate nhỏ nhất 0.")
	@Max(value = 100, message = "wastage_rate lớn nhất 100.")
	@JsonProperty("wastage_rate")
	private float wastageRate;

	@Min(value = 0 , message = "out_stock_alert_quantity nhỏ nhất 0.")
	@Max(value = 10000, message = "out_stock_alert_quantity lớn nhất 10000.")
	@JsonProperty("out_stock_alert_quantity")
	private float outStockAlertQuantity;

	@Min(value = 0 , message = "retail_price nhỏ nhất 0.")
	@Max(value = 10000000, message = "retail_price lớn nhất 10.000.000.")
	@JsonProperty("retail_price")
	private double retailPrice;

	@Min(value = 0 , message = "cost_price nhỏ nhất 0.")
	@Max(value = 10000000, message = "cost_price lớn nhất 10.000.000.")
	@JsonProperty("cost_price")
	private double costPrice;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public float getWastageRate() {
		return wastageRate;
	}

	public void setWastageRate(float wastageRate) {
		this.wastageRate = wastageRate;
	}

	public float getOutStockAlertQuantity() {
		return outStockAlertQuantity;
	}

	public void setOutStockAlertQuantity(float outStockAlertQuantity) {
		this.outStockAlertQuantity = outStockAlertQuantity;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	
	
	

}
