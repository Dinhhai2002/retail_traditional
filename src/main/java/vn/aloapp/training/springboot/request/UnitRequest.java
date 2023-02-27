package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UnitRequest {

	@Min(value = 0, message = "nhỏ nhất 0.")
	@Min(value = 1, message = "nhỏ nhất 1.")
	@JsonProperty("is_accept")
	private int isAccept;

	public int getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(int isAccept) {
		this.isAccept = isAccept;
	}
}
