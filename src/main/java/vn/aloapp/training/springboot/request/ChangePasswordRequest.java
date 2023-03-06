package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangePasswordRequest {
	
	@NotEmpty(message = "old_password không được được để trống")
	@Length(max = 50, message = "old_password Không được phép lớn hơn 50 kí tự")
	@JsonProperty("old_password")
	private String oldPassword;
	
	
	@NotEmpty(message = "password không được được để trống")
	@Length(max = 50, message = "password không được phép lớn hơn 50 kí tự")
	private String password;
	
	@NotEmpty(message = "confirm_password không được được để trống")
	@Length(max = 50, message = "confirm_password Không được phép lớn hơn 50 kí tự")
	@JsonProperty("confirm_password")
	private String confirmPassword;
	
	

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

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	
	
	

}
