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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "full_name")
	private String fullName;

	private int gender;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

	private String email;

	@Column(name = "is_expire")
	private int isExpire;

	private String avatar;

	@Column(name = "ward_id")
	private int wardId;

	@Column(name = "city_id")
	private int cityId;

	@Column(name = "district_id")
	private int districtId;

	@Column(name = "fb_uid")
	private String fbUid;

	@Column(name = "gg_uid")
	private String ggUid;

	@Column(name = "apple_uid")
	private String appleUid;

	private String phone;

	private String password;

	@Column(name = "auth_type")
	private int authType;

	@Column(name = "verify_code")
	private String verifyCode;

	@Column(name = "verify_fail_count")
	private int verifyFailCount;

	@Column(name = "is_verified")
	private int isVerified;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_activity_at")
	private Date lastActivityAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_at")
	private Date lastLoginAt;

	@Column(name = "access_token")
	private String accessToken;

	@Column(name = "refesh_token")
	private String refeshToken;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "is_verify_code_at")
	private Date isVerifyCodeAt;

	@Column(name = "is_login")
	private int isLogin;


}
