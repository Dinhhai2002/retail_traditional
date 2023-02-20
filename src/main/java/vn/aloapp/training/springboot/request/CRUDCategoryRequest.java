package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CRUDCategoryRequest extends BaseRequest{

	@JsonProperty("user_id")
    private int userId;

	@NotNull(message = "Tên không được phép null")
	@NotEmpty(message = "Tên không được được để trống")
    private String name;

    private String description;

    private int sort;
}
