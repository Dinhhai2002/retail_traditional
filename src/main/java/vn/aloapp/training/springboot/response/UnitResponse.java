package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.Unit;


public class UnitResponse {
	
	private int id;

	private String name;

	@JsonProperty("user_id")
	private int userId;

	private String description;

	private int status;
	
	@JsonProperty("create_at")
	private Date createAt;
	
	public UnitResponse () {
		
	}
	
	public UnitResponse(Unit entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.userId = entity.getUserId();
		this.description = entity.getDescription();
		this.status = entity.getStatus();
		this.createAt = entity.getCreatedAt();
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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
}
