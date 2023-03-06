package vn.aloapp.training.springboot.response;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.common.UtilsResponse;
import vn.aloapp.training.springboot.entity.WarehouseSession;



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
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("list")
	private List<WarehouseSessionDetailResponse> list;
	
	public WarehouseSessionResponse() {
		
	}
	
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
		
		this.createdAt = entity.getCreatedAtFormatVN(); 
		
		this.list = new ArrayList<>();
	}
	
	public List<WarehouseSessionResponse> mapToList(List<WarehouseSession> entities) {
		return entities.stream().map(x -> new WarehouseSessionResponse(x)).collect(Collectors.toList());
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

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getAdditionFeeId() {
		return additionFeeId;
	}

	public void setAdditionFeeId(long additionFeeId) {
		this.additionFeeId = additionFeeId;
	}

	public int getReceiptNumberNo() {
		return receiptNumberNo;
	}

	public void setReceiptNumberNo(int receiptNumberNo) {
		this.receiptNumberNo = receiptNumberNo;
	}

	public int getDiscountType() {
		return discountType;
	}

	public void setDiscountType(int discountType) {
		this.discountType = discountType;
	}

	public int getIsIncludeVat() {
		return isIncludeVat;
	}

	public void setIsIncludeVat(int isIncludeVat) {
		this.isIncludeVat = isIncludeVat;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}


	public List<WarehouseSessionDetailResponse> getList() {
		return list;
	}

	public void setList(List<WarehouseSessionDetailResponse> list) {
		this.list = list;
	}

	
}
