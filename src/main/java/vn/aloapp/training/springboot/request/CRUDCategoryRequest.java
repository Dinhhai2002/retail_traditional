package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CRUDCategoryRequest extends BaseRequest{

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@JsonProperty("user_id")
    private int userId;

	@NotNull(message = "Tên không được phép null")
	@NotEmpty(message = "Tên không được được để trống")
    private String name;

    private String description;

	@Min(value = 0 , message = "nhỏ nhất 0.")
	@Max(value = 100, message = "lớn nhất 100.")
    private int sort;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	
	
}
