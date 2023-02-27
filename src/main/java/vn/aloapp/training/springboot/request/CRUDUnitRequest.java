package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CRUDUnitRequest extends BaseRequest{
	

	@NotEmpty(message = "Tên đơn vị không được để trống")
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String name;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@JsonProperty("user_id")
	private int userId;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
