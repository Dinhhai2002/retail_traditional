package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.aloapp.training.springboot.entity.WarehouseSession;


@Data
@Setter
@Getter
@NoArgsConstructor
public class WarehouseSessionResponse {
	
	private long id;
	
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
	
	@JsonProperty("list")
	private ObjectList list;
	
	public WarehouseSessionResponse(WarehouseSession entity) {
		this.id = entity.getId();
		this.userId = entity.getUserId();
		this.supplierId = entity.getSupplierId();
		this.code = entity.getCode();
		this.amount = entity.getAmount();
		this.discountPercent = entity.getDiscountPercent();
		this.vat = entity.getVat();
		this.vatAmount  = entity.getVatAmount();
		this.discountAmount = entity.getDiscountAmount();
		this.totalAmount = entity.getTotalAmount();
		this.type = entity.getType();
		this.status = entity.getStatus();
		this.additionFeeId = entity.getAdditionFeeId();
		this.receiptNumberNo = entity.getReceiptNumberNo();
		this.discountType  = entity.getDiscountType();
		this.isIncludeVat = entity.getIsIncludeVat();
		this.description = entity.getDescription();
		this.createAt = entity.getCreatedAt();
		this.list = new ObjectList();
	}
	
	public List<WarehouseSessionResponse> mapToList(List<WarehouseSession> entities) {
		return entities.stream().map(x -> new WarehouseSessionResponse(x)).collect(Collectors.toList());
	}
	

}
