package vn.aloapp.training.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="categories")
public class ConfigLogin extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column(name = "secret_key")
	private String secretKey;


	@Column(name = "api_key")
	private String apiKey;


	@Column(name = "oauth_domain")
	private String oauthDomain;


	@Column(name = "material_domain")
	private String materialDomain;


	@Column(name = "warehouse_domain")
	private String warehouseDomain;


	@Column(name = "order_domain")
	private String orderDomain;


	@Column(name = "report_domain")
	private String reportDomain;


	@Column(name = "api_upload")
	private String apiUpload;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSecretKey() {
		return secretKey;
	}


	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}


	public String getApiKey() {
		return apiKey;
	}


	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}


	public String getOauthDomain() {
		return oauthDomain;
	}


	public void setOauthDomain(String oauthDomain) {
		this.oauthDomain = oauthDomain;
	}


	public String getMaterialDomain() {
		return materialDomain;
	}


	public void setMaterialDomain(String materialDomain) {
		this.materialDomain = materialDomain;
	}


	public String getWarehouseDomain() {
		return warehouseDomain;
	}


	public void setWarehouseDomain(String warehouseDomain) {
		this.warehouseDomain = warehouseDomain;
	}


	public String getOrderDomain() {
		return orderDomain;
	}


	public void setOrderDomain(String orderDomain) {
		this.orderDomain = orderDomain;
	}


	public String getReportDomain() {
		return reportDomain;
	}


	public void setReportDomain(String reportDomain) {
		this.reportDomain = reportDomain;
	}


	public String getApiUpload() {
		return apiUpload;
	}


	public void setApiUpload(String apiUpload) {
		this.apiUpload = apiUpload;
	}



}
