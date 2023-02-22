package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.aloapp.training.springboot.entity.Category;
import vn.aloapp.training.springboot.entity.WarehouseSessionDetail;

@Data
@Setter
@Getter
@NoArgsConstructor
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
	
	private float quantity;
	
	@JsonProperty("total_amount")
	private double totalAmount;
	
	@JsonProperty("warehouse_session_type")
	private int warehouseSessionType;
	
	@JsonProperty("warehouse_session_status")
	private int warehouseSessionStatus;
	
	@JsonProperty("create_at")
	private Date createAt;
	
	
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
		this.createAt = entity.getCreatedAt();	
		
	}
	
	
	public List<WarehouseSessionDetailResponse> mapToList(List<WarehouseSessionDetail> entities) {
		return entities.stream().map(x -> new WarehouseSessionDetailResponse(x)).collect(Collectors.toList());
	}

}
