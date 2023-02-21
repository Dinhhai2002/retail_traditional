package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.Material;

public interface MaterialService {

	Material spUCreateMaterial(Material material) throws Exception;

	Material findOne(Integer id) throws Exception;

	Material spUUpdateMaterial(Material material) throws Exception;

	List<Material> spGListMaterial(Integer status) throws Exception;

	void spUChangeStatusMaterial(int id) throws Exception;
	List<Material> spGMaterialsByCategoryId(String categoryId) throws Exception;

	void spUDeleteCategoryIdByMaterial(int id) throws Exception;

	void spUDeleteUnitIdByMaterial(int id) throws Exception;


}
