package vn.aloapp.training.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="materials")
public class Material extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String code;

	private String name;

	@Column(name = "prefix_name")
	private String prefixName;

	@Column(name = "normalize_name")
	private String normalizeName;

	@Column(name = "user_id")
	private int userId;

	private String avatar;

	@Column(name = "avatar_thumb")
	private String avatarThumb;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "unit_id")
	private int unitId;

	@Column(name = "wastage_rate")
	private float wastageRate;

	@Column(name = "out_stock_alert_quantity")
	private float outStockAlertQuantity;

	@Column(name = "retail_price")
	private double retailPrice;

	@Column(name = "cost_price")
	private double costPrice;

	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefixName() {
		return prefixName;
	}

	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}

	public String getNormalizeName() {
		return normalizeName;
	}

	public void setNormalizeName(String normalizeName) {
		this.normalizeName = normalizeName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatarThumb() {
		return avatarThumb;
	}

	public void setAvatarThumb(String avatarThumb) {
		this.avatarThumb = avatarThumb;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public float getWastageRate() {
		return wastageRate;
	}

	public void setWastageRate(float wastageRate) {
		this.wastageRate = wastageRate;
	}

	public float getOutStockAlertQuantity() {
		return outStockAlertQuantity;
	}

	public void setOutStockAlertQuantity(float outStockAlertQuantity) {
		this.outStockAlertQuantity = outStockAlertQuantity;
	}

	public double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	


}
