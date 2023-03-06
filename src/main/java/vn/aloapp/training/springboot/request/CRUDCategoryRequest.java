package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CRUDCategoryRequest extends BaseRequest {

	@NotEmpty(message = "name không được được để trống")
	private String name;

	@NotNull(message = "description không được phép null")
	private String description;


	@Min(value = 0, message = "sort nhỏ nhất 0.")
	@Max(value = 100, message = "sort lớn nhất 100.")
	private int sort;

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
