package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class CRUDMaterialRequest extends BaseRequest{

	
	@NotNull(message = "Tên không được phép null")
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String name;

	@Min(value = 0, message = "nhỏ nhất 0")
	@JsonProperty("user_id")
	private int userId;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String avatar;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("avatar_thumb")
	private String avatarThumb;

	@Min(value = 0, message = "nhỏ nhất 0")
	@JsonProperty("category_id")
	private int categoryId;

	@Min(value = 0, message = "nhỏ nhất 0")
	@JsonProperty("unit_id")
	private int unitId;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 100, message = "lớn nhất 100.")
	@JsonProperty("wastage_rate")
	private float wastageRate;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 10000, message = "lớn nhất 10000.")
	@JsonProperty("out_stock_alert_quantity")
	private float outStockAlertQuantity;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 10000000, message = "lớn nhất 10.000.000.")
	@NotNull(message = "out_stock_alert_quantity không được phép null")
	@JsonProperty("retail_price")
	private double retailPrice;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 10000000, message = "lớn nhất 10.000.000.")
	@JsonProperty("cost_price")
	private double costPrice;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatarThumb() {
		return avatarThumb;
	}

	public void setAvatarThumb(String avatarThumb) {
		this.avatarThumb = avatarThumb;
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
