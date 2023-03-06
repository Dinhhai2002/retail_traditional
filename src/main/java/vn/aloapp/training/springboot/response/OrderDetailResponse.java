package vn.aloapp.training.springboot.response;


import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.common.UtilsResponse;
import vn.aloapp.training.springboot.entity.OrderDetail;


public class OrderDetailResponse {
	
	
	private long id;

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("order_id")
	private long orderId;

	@JsonProperty("category_id")
	private int categoryId;

	@JsonProperty("category_name")
	private String categoryName;

	@JsonProperty("material_unit_id")
	private int materialUnitId;

	@JsonProperty("material_unit_name")
	private String materialUnitName;

	@JsonProperty("material_id")
	private int materialId;

	@JsonProperty("material_name")
	private String materialName;

	private double price;

	@JsonProperty("cost_price")
	private double costPrice;

	private BigDecimal quantity;

	private int type;

	@JsonProperty("total_cost_price_amount")
	private double totalCostPriceAmount;

	@JsonProperty("total_amount")
	private double totalAmount;

	private int status;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	public OrderDetailResponse() {
	}
	
	public OrderDetailResponse(OrderDetail entity) {
		this.id = entity.getId();
		this.userId = entity.getUserId();
		this.orderId = entity.getOrderId();
		this.categoryId = entity.getCategoryId();
		this.categoryName = entity.getCategoryName();
		this.materialUnitId = entity.getMaterialUnitId();
		this.materialUnitName = entity.getMaterialUnitName();
		this.materialId = entity.getMaterialId();
		this.materialName = entity.getMaterialName();
		this.price = entity.getPrice();
		this.costPrice = entity.getCostPrice();
		this.quantity = entity.getQuantity();
		this.type = entity.getType();
		this.totalCostPriceAmount = entity.getTotalCostPriceAmount();
		this.totalAmount = entity.getTotalAmount();
		this.status = entity.getStatus();	
		try {
			this.createdAt = UtilsResponse.formatDate(entity.getCreatedAt().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public List<OrderDetailResponse> mapToList(List<OrderDetail> entities) {
		return entities.stream().map(x -> new OrderDetailResponse(x)).collect(Collectors.toList());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getMaterialUnitId() {
		return materialUnitId;
	}

	public void setMaterialUnitId(int materialUnitId) {
		this.materialUnitId = materialUnitId;
	}

	public String getMaterialUnitName() {
		return materialUnitName;
	}

	public void setMaterialUnitName(String materialUnitName) {
		this.materialUnitName = materialUnitName;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getTotalCostPriceAmount() {
		return totalCostPriceAmount;
	}

	public void setTotalCostPriceAmount(double totalCostPriceAmount) {
		this.totalCostPriceAmount = totalCostPriceAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


}
