package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CRUDUserRequest extends BaseRequest {

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;
	
	@NotEmpty(message="tên không được trống")
	@JsonProperty("full_name")
	private String fullName;

	private int gender;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date birthday;

	private String email;

	@JsonProperty("is_expire")
	private int isExpire;

	private String avatar;

	@JsonProperty("ward_id")
	private int wardId;

	@JsonProperty("city_id")
	private int cityId;

	@JsonProperty("district_id")
	private int districtId;

	@JsonProperty("fb_uid")
	private String fbUid;

	@JsonProperty("gg_uid")
	private String ggUid;

	@JsonProperty("apple_uid")
	private String appleUid;

	private String phone;

	private String password;

	@JsonProperty("auth_type")
	private int authType;

	@JsonProperty("verify_code")
	private String verifyCode;

	@JsonProperty("verify_fail_count")
	private int verifyFailCount;

	@JsonProperty("is_verified")
	private int isVerified;

//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonProperty("last_activity_at")
//	private Date lastActivityAt;
//
//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonProperty("last_login_at")
//	private Date lastLoginAt;

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("refesh_token")
	private String refeshToken;

//	@Temporal(TemporalType.TIMESTAMP)
//	@JsonProperty("is_verify_code_at")
//	private Date isVerifyCodeAt;

	@JsonProperty("is_login")
	private int isLogin;
}
