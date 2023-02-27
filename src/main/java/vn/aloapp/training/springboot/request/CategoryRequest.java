package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryRequest {
	
	@Min(value = 0, message = "chỉ có 2 giá trị 0 hoặc 1")
	@Max(value = 1, message = "chỉ có 2 giá trị 0 hoặc 1")
	@JsonProperty("is_accept")
	private int isAccept;

	public int getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(int isAccept) {
		this.isAccept = isAccept;
	}

	
}
