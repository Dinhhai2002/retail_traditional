package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CRUDUnitRequest extends BaseRequest{
	

	@NotEmpty(message = "Tên đơn vị không được để trống")
	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	private String name;

	@NotNull(message = "Mã người tạo không được null")
	@JsonProperty("user_id")
	private int userId;

	private String description;


}
