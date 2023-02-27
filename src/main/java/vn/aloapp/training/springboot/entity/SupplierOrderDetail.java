package vn.aloapp.training.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public long getSupplierOrderId() {
		return supplierOrderId;
	}

	public void setSupplierOrderId(long supplierOrderId) {
		this.supplierOrderId = supplierOrderId;
	}

	public int getMaterialCategoryId() {
		return materialCategoryId;
	}

	public void setMaterialCategoryId(int materialCategoryId) {
		this.materialCategoryId = materialCategoryId;
	}

	public String getMaterialCategoryName() {
		return materialCategoryName;
	}

	public void setMaterialCategoryName(String materialCategoryName) {
		this.materialCategoryName = materialCategoryName;
	}

	public long getUnitId() {
		return unitId;
	}

	public void setUnitId(long unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public int getMaterialId() {
		return materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getAcceptQuantity() {
		return acceptQuantity;
	}

	public void setAcceptQuantity(String acceptQuantity) {
		this.acceptQuantity = acceptQuantity;
	}

	public double getReturnQuantity() {
		return returnQuantity;
	}

	public void setReturnQuantity(double returnQuantity) {
		this.returnQuantity = returnQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalReturnPrice() {
		return totalReturnPrice;
	}

	public void setTotalReturnPrice(double totalReturnPrice) {
		this.totalReturnPrice = totalReturnPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	


}
