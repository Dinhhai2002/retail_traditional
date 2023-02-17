package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.aloapp.training.springboot.entity.Category;

@Data
@Setter
@Getter
@NoArgsConstructor
public class CategoryResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonProperty("user_id")
    private int userId;

    private String code;

    private String name;

    @JsonProperty("prefix_name")
    private String prefixName;

    @JsonProperty("normalize_name")
    private String normalizeName;

    private String description;

    private int sort;

    private int status;
    
	@JsonProperty("create_at")
	private Date createAt;
    
    public CategoryResponse (Category entity) {
		this.id = entity.getId();
		this.userId = entity.getId();
		this.code = entity.getCode();
		this.name = entity.getName();
		this.prefixName = entity.getPrefixName();
		this.normalizeName = entity.getNormalizeName();
		this.description = entity.getDescription();
		this.sort = entity.getSort();
		this.status = entity.getStatus();
		this.createAt = entity.getCreatedAt();
		
	}

	public List<CategoryResponse> mapToList(List<Category> entities) {
		return entities.stream().map(x -> new CategoryResponse(x)).collect(Collectors.toList());
	}

}
