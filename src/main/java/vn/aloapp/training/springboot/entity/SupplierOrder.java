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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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


}
