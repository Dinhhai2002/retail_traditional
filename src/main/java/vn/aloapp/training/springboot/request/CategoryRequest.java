package vn.aloapp.training.springboot.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryRequest {
	@JsonProperty("is_accept")
	private int isAccept;

	public int getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(int isAccept) {
		this.isAccept = isAccept;
	}

	
}
