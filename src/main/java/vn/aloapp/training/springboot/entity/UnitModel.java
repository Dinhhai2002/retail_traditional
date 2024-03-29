package vn.aloapp.training.springboot.entity;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
public class UnitModel {

	@Id
	private int id;

	private String name;

	@Column(name = "user_id")
	private int userId;

	private String description;

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
	
	
}
