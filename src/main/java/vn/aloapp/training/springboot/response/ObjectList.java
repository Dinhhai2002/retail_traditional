package vn.aloapp.training.springboot.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectList<T> {
	@JsonProperty("list")
	private List<T> list ;

	public List<T> getList() {
		return list == null ? new ArrayList<>() : list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	

}
