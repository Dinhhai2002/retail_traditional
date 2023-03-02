package vn.aloapp.training.springboot.request;

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
	
	
	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 1, message = "lớn nhất 1.")
	private int gender;
	
	@Pattern(regexp="(^$|[0-9]{10})", message = " chỉ được phép nhập số và tối đa 10 số.")
	private String phone;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String password;


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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
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

	
	
}
