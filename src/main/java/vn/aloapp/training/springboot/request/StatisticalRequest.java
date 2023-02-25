package vn.aloapp.training.springboot.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticalRequest {
	@JsonProperty("input")
    private int input;

	@JsonProperty("from_date_string")
    private String fromDateString;

	@JsonProperty("to_date_string")
    private String toDateString;
	
	private int type;
}
