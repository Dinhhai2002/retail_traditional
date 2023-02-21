package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.aloapp.training.springboot.entity.Unit;

@Data
@Setter
@Getter
@NoArgsConstructor
public class UnitResponse {
	
	private int id;

	private String name;

	@JsonProperty("user_id")
	private int userId;

	private String description;

	private int status;
	
	@JsonProperty("create_at")
	private Date createAt;
	
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

}
