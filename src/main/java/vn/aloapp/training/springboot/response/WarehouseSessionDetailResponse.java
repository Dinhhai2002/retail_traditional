package vn.aloapp.training.springboot.response;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;


import vn.aloapp.training.springboot.entity.WarehouseSessionDetail;

public class WarehouseSessionDetailResponse {
	
	private long id;

	@JsonProperty("user_id")
	private int userId;
	
	@JsonProperty("warehouse_session_id")
	private long warehouseSessionId;
	
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
	
	private BigDecimal quantity;
	
	@JsonProperty("total_amount")
	private double totalAmount;
	
	@JsonProperty("warehouse_session_type")
	private int warehouseSessionType;
	
	@JsonProperty("warehouse_session_status")
	private int warehouseSessionStatus;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	public WarehouseSessionDetailResponse() {
		
	}
	
	public WarehouseSessionDetailResponse (WarehouseSessionDetail entity) {
		this.id = entity.getId();
		this.userId = entity.getUserId();
		this.warehouseSessionId = entity.getWarehouseSessionId();
		this.categoryId = entity.getCategoryId();
		this.categoryName = entity.getCategoryName();
		this.materialUnitId = entity.getMaterialUnitId();
		this.materialUnitName = entity.getMaterialUnitName();
		this.materialId = entity.getMaterialId();
		this.materialName = entity.getMaterialName();
		this.price = entity.getPrice();
		this.quantity = entity.getQuantity();
		this.totalAmount = entity.getTotalAmount();
		this.warehouseSessionType = entity.getWarehouseSessionType();
		this.warehouseSessionStatus = entity.getWarehouseSessionStatus();
		try {
			this.createdAt = UtilsResponse.formatDate(entity.getCreatedAt().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<WarehouseSessionDetailResponse> mapToList(List<WarehouseSessionDetail> entities) {
		return entities.stream().map(x -> new WarehouseSessionDetailResponse(x)).collect(Collectors.toList());
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


	public long getWarehouseSessionId() {
		return warehouseSessionId;
	}


	public void setWarehouseSessionId(long warehouseSessionId) {
		this.warehouseSessionId = warehouseSessionId;
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


	public BigDecimal getQuantity() {
		return quantity;
	}


	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public int getWarehouseSessionType() {
		return warehouseSessionType;
	}


	public void setWarehouseSessionType(int warehouseSessionType) {
		this.warehouseSessionType = warehouseSessionType;
	}


	public int getWarehouseSessionStatus() {
		return warehouseSessionStatus;
	}


	public void setWarehouseSessionStatus(int warehouseSessionStatus) {
		this.warehouseSessionStatus = warehouseSessionStatus;
	}


	public String getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(String createAt) {
		this.createdAt = createAt;
	}

	
	
}
