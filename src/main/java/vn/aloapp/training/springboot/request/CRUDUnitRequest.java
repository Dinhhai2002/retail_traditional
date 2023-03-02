package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


public class CRUDUnitRequest extends BaseRequest{
	

	@NotEmpty(message = "Tên đơn vị không được để trống")
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String name;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
