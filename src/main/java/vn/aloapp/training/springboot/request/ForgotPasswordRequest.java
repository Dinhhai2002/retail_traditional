package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ForgotPasswordRequest {

	@NotNull(message = "phone không được phép null")
	@Pattern(regexp="(^$|[0-9]{10})", message = " chỉ được phép nhập số và tối đa 10 số.")
	private String phone;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
}
