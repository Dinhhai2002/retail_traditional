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

}
