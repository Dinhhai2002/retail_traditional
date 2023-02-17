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
@Table(name="supplier_order_details")
public class SupplierOrderDetail extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name = "supplier_id")
	private int supplierId;

	@Column(name = "supplier_order_id")
	private long supplierOrderId;

	@Column(name = "material_category_id")
	private int materialCategoryId;
	
	@Column(name = "material_category_name")
	private String materialCategoryName;
	
	@Column(name = "unit_id")
	private long unitId;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "material_id")
	private int materialId;
	
	@Column(name = "material_name")
	private String materialName;
	
	@Column(name = "accept_quantity")
	private String acceptQuantity;

	@Column(name = "return_quantity")
	private double returnQuantity;
	
	private double price;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "total_return_price")
	private double totalReturnPrice;

	private int status;

	@Column(name = "is_deleted")
	private int isDeleted;


}
