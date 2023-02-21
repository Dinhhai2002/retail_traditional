package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CRUDMaterialRequest extends BaseRequest{

	

	@NotNull(message = "Tên không được phép null")
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String name;

	@NotNull(message = "user_id không được phép null")
	@JsonProperty("user_id")
	private int userId;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String avatar;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
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
	


}
