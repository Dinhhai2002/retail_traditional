package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.Order;


public class OrderResponse {
	
	private long id;

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("customer_debt_id")
	private long customerDebtId;

	private String code;

	private double amount;

	private double vat;

	@JsonProperty("vat_amount")
	private double vatAmount;

	@JsonProperty("discount_percent")
	private double discountPercent;

	@JsonProperty("discount_amount")
	private double discountAmount;

	@JsonProperty("total_amount")
	private double totalAmount;

	private int type;

	@JsonProperty("discount_type")
	private int discountType;

	@JsonProperty("is_include_vat")
	private int isIncludeVat;

	private int status;

	@JsonProperty("receipt_number_no")
	private int receiptNumberNo;

	private String description;
	
	@JsonProperty("create_at")
	private Date createAt;
	
	 @JsonProperty("list")
	private ObjectList orderDetails;
	 
	 public OrderResponse() {
		// TODO Auto-generated constructor stub
	}
	 
	public OrderResponse (Order entity) {
		this.id = entity.getId();
		this.userId = entity.getUserId();
		this.customerDebtId = entity.getCustomerDebtId();
		this.code = entity.getCode();
		this.amount = entity.getAmount();
		this.vat = entity.getVat();
		this.vatAmount = entity.getVatAmount();
		this.discountPercent = entity.getDiscountPercent();
		this.discountAmount = entity.getDiscountAmount();
		this.totalAmount = entity.getTotalAmount();
		this.type = entity.getType();
		this.discountType = entity.getDiscountType();
		this.isIncludeVat = entity.getIsIncludeVat();
		this.status = entity .getStatus();
		this.receiptNumberNo = entity.getReceiptNumberNo();
		this.description = entity.getDescription();
		this.createAt = entity.getCreatedAt();
		this.orderDetails = new ObjectList<>();
	}
	
	public List<OrderResponse> mapToList(List<Order> entities) {
		return entities.stream().map(x -> new OrderResponse(x)).collect(Collectors.toList());
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

	public long getCustomerDebtId() {
		return customerDebtId;
	}

	public void setCustomerDebtId(long customerDebtId) {
		this.customerDebtId = customerDebtId;
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

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getReceiptNumberNo() {
		return receiptNumberNo;
	}

	public void setReceiptNumberNo(int receiptNumberNo) {
		this.receiptNumberNo = receiptNumberNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public ObjectList getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(ObjectList orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	
}
