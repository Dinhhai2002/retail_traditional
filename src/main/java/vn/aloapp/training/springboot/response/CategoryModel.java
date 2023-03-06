package vn.aloapp.training.springboot.response;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.springboot.entity.MaterialModel;


@Entity
public class CategoryModel {
	
	@Id
	private int id;
	
	@Column(name = "user_id")
    private int userId;

    private String code;

    private String name;

	@Column(name = "prefix_name")
    private String prefixName;

    @Column(name = "normalize_name")
    private String normalizeName;

    private String description;

    private int sort;

    private int status;
    
   
	@Column(name = "listMaterials")
	private String listMaterials;
	
	public List<MaterialModel> getLists() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<MaterialModel> reaturantMaterial = Arrays
					.asList(mapper.readValue(this.listMaterials , MaterialModel[].class));
			return reaturantMaterial;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefixName() {
		return prefixName;
	}

	public void setPrefixName(String prefixName) {
		this.prefixName = prefixName;
	}

	public String getNormalizeName() {
		return normalizeName;
	}

	public void setNormalizeName(String normalizeName) {
		this.normalizeName = normalizeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
