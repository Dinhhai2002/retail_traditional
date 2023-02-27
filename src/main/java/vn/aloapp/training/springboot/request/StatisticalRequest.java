package vn.aloapp.training.springboot.request;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticalRequest {
	
	@Min(value = 0, message = "nhỏ nhất 0")
	@JsonProperty("input")
    private int input;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("from_date_string")
    private String fromDateString;

	@Length(max = 255, message = "Không được phép lớn hơn 255 kí tự")
	@JsonProperty("to_date_string")
    private String toDateString;
	
	@Min(value = 1, message = "nhỏ nhất 1.")
	@Min(value = 5, message = "nhỏ nhất 5.")
	private int type;
}
