package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ResetPasswordRequest {
	
	@NotNull(message = "otp không được phép null")
	@Pattern(regexp="(^$|[0-9]{4})", message = "OTP chỉ được phép nhập số và tối đa 4 số.")
	private String otp;
	
	@NotNull(message = "password không được phép null")
	@Length(max = 50, message = "password không được phép lớn hơn 50 kí tự")
	private String password;
	
	@NotNull(message = "confirm_password không được phép null")
	@Length(max = 50, message = "confirm_password Không được phép lớn hơn 50 kí tự")
	@JsonProperty("confirm_password")
	private String confirmPassword;

	

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	

}
