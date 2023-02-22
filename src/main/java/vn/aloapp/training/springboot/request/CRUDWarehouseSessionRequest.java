package vn.aloapp.training.springboot.request;

import java.util.Date;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CRUDWarehouseSessionRequest {
	@Min(value=1)
	@JsonProperty("user_id")
	private int userId;
	
	@JsonProperty("supplier_id")
	private int supplierId;
	
	private String code;
	
	private double amount;
	
	@JsonProperty("discount_percent")
	private double discountPercent;
	
	private double vat;
	
	@JsonProperty("vat_amount")
	private double vatAmount;
	
	@JsonProperty("discount_amount")
	private double discountAmount;
	
	@JsonProperty("total_amount")
	private double totalAmount;
	
	private int type;
	
	private int status;
	
	@JsonProperty("addition_fee_id")
	private long additionFeeId;
	
	@JsonProperty("receipt_number_no")
	private int receiptNumberNo;
	
	@JsonProperty("discount_type")
	private int discountType;
	
	@JsonProperty("is_include_vat")
	private int isIncludeVat;
	
	private String description;
	
	@JsonProperty("create_at")
	private Date createAt;
	
	private Object warehouseSessionDetail;
}