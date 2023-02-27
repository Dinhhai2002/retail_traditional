package vn.aloapp.training.springboot.response;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.User;


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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsExpire() {
		return isExpire;
	}

	public void setIsExpire(int isExpire) {
		this.isExpire = isExpire;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getWardId() {
		return wardId;
	}

	public void setWardId(int wardId) {
		this.wardId = wardId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getFbUid() {
		return fbUid;
	}

	public void setFbUid(String fbUid) {
		this.fbUid = fbUid;
	}

	public String getGgUid() {
		return ggUid;
	}

	public void setGgUid(String ggUid) {
		this.ggUid = ggUid;
	}

	public String getAppleUid() {
		return appleUid;
	}

	public void setAppleUid(String appleUid) {
		this.appleUid = appleUid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		byte[] decodedBytes = Base64.getDecoder().decode(password);
		return new String(decodedBytes);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAuthType() {
		return authType;
	}

	public void setAuthType(int authType) {
		this.authType = authType;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public int getVerifyFailCount() {
		return verifyFailCount;
	}

	public void setVerifyFailCount(int verifyFailCount) {
		this.verifyFailCount = verifyFailCount;
	}

	public int getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(int isVerified) {
		this.isVerified = isVerified;
	}

	public Date getLastActivityAt() {
		return lastActivityAt;
	}

	public void setLastActivityAt(Date lastActivityAt) {
		this.lastActivityAt = lastActivityAt;
	}

	public Date getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefeshToken() {
		return refeshToken;
	}

	public void setRefeshToken(String refeshToken) {
		this.refeshToken = refeshToken;
	}

	public Date getIsVerifyCodeAt() {
		return isVerifyCodeAt;
	}

	public void setIsVerifyCodeAt(Date isVerifyCodeAt) {
		this.isVerifyCodeAt = isVerifyCodeAt;
	}

	public int getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}
	
	
	
	
}