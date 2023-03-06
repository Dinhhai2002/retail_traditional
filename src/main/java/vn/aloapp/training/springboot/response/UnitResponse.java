package vn.aloapp.training.springboot.response;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.common.UtilsResponse;
import vn.aloapp.training.springboot.entity.Unit;


public class UnitResponse {
	
	private int id;

	private String name;

	@JsonProperty("user_id")
	private int userId;

	private String description;

	private int status;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	public UnitResponse () {
		
	}
	
	public UnitResponse(Unit entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.userId = entity.getUserId();
		this.description = entity.getDescription();
		this.status = entity.getStatus() ? 1 : 0;
		try {
			this.createdAt = UtilsResponse.formatDate(entity.getCreatedAt().toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public List<UnitResponse> mapToList(List<Unit> entities) {
		return entities.stream().map(x -> new UnitResponse(x)).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	

	
}
