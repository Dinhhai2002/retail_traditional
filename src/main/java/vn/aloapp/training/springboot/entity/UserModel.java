package vn.aloapp.training.springboot.entity;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class UserModel {
	
	@Pattern(regexp="(^$|[0-9]{10})", message = " chỉ được phép nhập số và tối đa 10 số.")
	private String phone;
	
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@Length(min = 2, message = "ít nhất 2 kí tự")
	private String password;

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
	
	
	

}
