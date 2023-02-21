package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.aloapp.training.springboot.entity.Material;

@Data
@Setter
@Getter
@NoArgsConstructor
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

}
