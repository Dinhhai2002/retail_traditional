package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
	
	@NotNull(message = "Code không được phép null")
	@Length(max = 11, message = "Không được phép lớn hơn 11 kí tự")
	private String code;

	@NotNull(message = "Tên không được phép null")
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String name;

	@NotNull(message = "Tên tiền tố không được phép null")
	@JsonProperty("prefix_name")
	private String prefixName;

	@NotNull(message = "Normalize_name tiền tố không được phép null")
	@JsonProperty("normalize_name")
	private String normalizeName;

	@NotNull(message = "user_id không được phép null")
	@JsonProperty("user_id")
	private int userId;

	@NotNull(message = "avatar không được phép null")
	private String avatar;

	@NotNull(message = "avatar_thumb không được phép null")
	@JsonProperty("avatar_thumb")
	private String avatarThumb;

	@NotNull(message = "category_id không được phép null")
	@JsonProperty("category_id")
	private int categoryId;

	@NotNull(message = "unit_id không được phép null")
	@JsonProperty("unit_id")
	private int unitId;

	@NotNull(message = "wastage_rate không được phép null")
	@JsonProperty("wastage_rate")
	private float wastageRate;

	@NotNull(message = "out_stock_alert_quantity không được phép null")
	@JsonProperty("out_stock_alert_quantity")
	private float outStockAlertQuantity;

	@NotNull(message = "out_stock_alert_quantity không được phép null")
	@JsonProperty("retail_price")
	private double retailPrice;

	@NotNull(message = "out_stock_alert_quantity không được phép null")
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
