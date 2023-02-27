package vn.aloapp.training.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="supplier_orders")
public class SupplierOrder extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	@Column(name = "user_id")
	private int userId;

	@Column(name = "supplier_id")
	private int supplierId;

	private String code;

	@Column(name = "warehouse_session_id")
	private long warehouseSessionId;

	private double amount;

	@Column(name = "total_material")
	private long totalMaterial;

	@Column(name = "discount_amount")
	private double discountAmount;

	@Column(name = "discount_percent")
	private long discountPercent;

	@Column(name = "total_amount")
	private double totalAmount;

	@Column(name = "payment_status")
	private int paymentStatus;

	@Column(name = "vat_amount")
	private double vatAmount;

	private double vat;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delivery_at")
	private Date deliveryAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_date")
	private Date paymentDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "received_at")
	private Date receivedAt;

	private int status;

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

	public long getWarehouseSessionId() {
		return warehouseSessionId;
	}

	public void setWarehouseSessionId(long warehouseSessionId) {
		this.warehouseSessionId = warehouseSessionId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getTotalMaterial() {
		return totalMaterial;
	}

	public void setTotalMaterial(long totalMaterial) {
		this.totalMaterial = totalMaterial;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}

	public long getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(long discountPercent) {
		this.discountPercent = discountPercent;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public Date getDeliveryAt() {
		return deliveryAt;
	}

	public void setDeliveryAt(Date deliveryAt) {
		this.deliveryAt = deliveryAt;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getReceivedAt() {
		return receivedAt;
	}

	public void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	


}
