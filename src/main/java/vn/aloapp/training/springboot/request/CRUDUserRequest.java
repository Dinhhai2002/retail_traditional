package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDUserRequest extends BaseRequest {

	
	@NotNull(message = "không được phép null")
	@NotEmpty(message = "không được phép để trống")
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("first_name")
	private String firstName;

	@NotNull(message = "không được phép null")
	@NotEmpty(message = "không được phép để trống")
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("last_name")
	private String lastName;
	
	@NotNull(message = "không được phép null")
	@NotEmpty(message = "không được phép để trống")
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("full_name")
	private String fullName;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 2, message = "lớn nhất 2.")
	private int gender;
	
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date birthday;

	@Email(message = "nhập đúng định dạng email.")
	private String email;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 1, message = "lớn nhất 1.")
	@JsonProperty("is_expire")
	private int isExpire;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String avatar;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 100000, message = "lớn nhất 100.000.")
	@JsonProperty("ward_id")
	private int wardId;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 100000, message = "lớn nhất 100.000.")
	@JsonProperty("city_id")
	private int cityId;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 100000, message = "lớn nhất 100.000.")
	@JsonProperty("district_id")
	private int districtId;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("fb_uid")
	private String fbUid;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("gg_uid")
	private String ggUid;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("apple_uid")
	private String appleUid;

	@Pattern(regexp="(^$|[0-9]{10})", message = " chỉ được phép nhập số và tối đa 10 số.")
	private String phone;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String password;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 1, message = "lớn nhất 1.")
	@JsonProperty("auth_type")
	private int authType;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("verify_code")
	private String verifyCode;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 100000, message = "lớn nhất 100.000.")
	@JsonProperty("verify_fail_count")
	private int verifyFailCount;

	
	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 1, message = "lớn nhất 1.")
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

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 1, message = "lớn nhất 1.")
	@JsonProperty("is_login")
	private int isLogin;

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
		return password;
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

	public int getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(int isLogin) {
		this.isLogin = isLogin;
	}
	
	
	
}
