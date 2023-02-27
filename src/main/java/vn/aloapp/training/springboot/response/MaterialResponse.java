package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.Material;

public class MaterialResponse{
	
	private int id;
	
	private String code;

	private String name;

	@JsonProperty("prefix_name")
	private String prefixName;

	@JsonProperty("normalize_name")
	private String normalizeName;

	@JsonProperty("user_id")
	private int userId;

	private String avatar;

	@JsonProperty("avatar_thumb")
	private String avatarThumb;

	@JsonProperty("category_id")
	private int categoryId;

	@JsonProperty("unit_id")
	private int unitId;

	@JsonProperty("wastage_rate")
	private float wastageRate;

	@JsonProperty("out_stock_alert_quantity")
	private float outStockAlertQuantity;

	@JsonProperty("retail_price")
	private double retailPrice;

	@JsonProperty("cost_price")
	private double costPrice;
	
	private int status;
	    
	@JsonProperty("create_at")
	private Date createAt;
	
	public MaterialResponse() {
		
	}
	
	
	public MaterialResponse(Material entity) {
		this.id = entity.getId();
		this.code = entity.getCode();
		this.name = entity.getName();
		this.avatar = entity.getAvatar();
		this.normalizeName = entity.getNormalizeName();
		this.prefixName = entity.getPrefixName();
		this.avatarThumb = entity.getAvatarThumb();
		this.userId = entity.getUserId();
		this.categoryId = entity.getCategoryId();
		this.unitId = entity.getUnitId();
		this.wastageRate = entity.getWastageRate();
		this.outStockAlertQuantity = entity.getOutStockAlertQuantity();
		this.retailPrice = entity.getRetailPrice();
		this.costPrice = entity.getCostPrice();
		this.status = entity.getStatus();
		this.createAt = entity.getCreatedAt();
	}
	
	
	public List<MaterialResponse> mapToList(List<Material> entities) {
		return entities.stream().map(x -> new MaterialResponse(x)).collect(Collectors.toList());
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPrefixName() {
		return prefixName;
	}


	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}


	public String getNormalizeName() {
		return normalizeName;
	}


	public void setNormalizeName(String normalizeName) {
		this.normalizeName = normalizeName;
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


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
}
