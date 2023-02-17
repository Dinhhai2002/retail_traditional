package vn.aloapp.training.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="warehouse_sessions")
public class WarehouseSession extends BaseEntity{
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
	
	private double amount;
	
	@Column(name = "discount_percent")
	private double discountPercent;
	
	private double vat;
	
	@Column(name = "vat_amount")
	private double vatAmount;
	
	@Column(name = "discount_amount")
	private double discountAmount;
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	private int type;
	
	private int status;
	
	@Column(name = "addition_fee_id")
	private long additionFeeId;
	
	@Column(name = "receipt_number_no")
	private int receiptNumberNo;
	
	@Column(name = "discount_type")
	private int discountType;
	
	@Column(name = "is_include_vat")
	private int isIncludeVat;
	
	private String description;
	

}
