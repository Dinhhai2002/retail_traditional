package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import vn.aloapp.training.springboot.entity.User;

@Setter
@Getter
public class UserResponse {
	private int id;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("full_name")
	private String fullName;

	private int gender;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

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

	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("last_activity_at")
	private Date lastActivityAt;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("last_login_at")
	private Date lastLoginAt;

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("refesh_token")
	private String refeshToken;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonProperty("is_verify_code_at")
	private Date isVerifyCodeAt;

	@JsonProperty("is_login")
	private int isLogin;

	public UserResponse() {
		
	}

	public UserResponse(User entity) {
		this.id = entity.getId();
		this.firstName = entity.getFirstName();
		this.lastName = entity.getLastName();
		this.fullName = entity.getFullName();
		this.gender = entity.getGender();
		this.birthday = entity.getBirthday();
		this.email = entity.getEmail();
		this.isExpire = entity.getIsExpire();
		this.avatar = entity.getAvatar();
		this.wardId = entity.getWardId();
		this.cityId = entity.getCityId();
		this.districtId = entity.getDistrictId();
		this.fbUid = entity.getFbUid();
		this.ggUid = entity.getGgUid();
		this.appleUid = entity.getAppleUid();
		this.phone = entity.getPhone();
		this.password = entity.getPassword();
		this.authType = entity.getAuthType();
		this.verifyCode = entity.getVerifyCode();
		this.verifyFailCount = entity.getVerifyFailCount();
		this.isVerified = entity.getIsVerified();
		this.lastActivityAt = entity.getLastActivityAt();
		this.lastLoginAt = entity.getLastLoginAt();
		this.accessToken = entity.getAccessToken();
		this.refeshToken = entity.getRefeshToken();
		this.isVerifyCodeAt = entity.getIsVerifyCodeAt();
		this.isLogin = entity.getIsLogin();
	}
	
	public List<UserResponse> mapToList(List<User> entities) {
		return entities.stream().map(x -> new UserResponse(x)).collect(Collectors.toList());
	}
	
	
}
