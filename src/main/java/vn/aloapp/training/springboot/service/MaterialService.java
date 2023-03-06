package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Material;

public interface MaterialService {

	

	Material findByUserIdAndMaterialId(int userId, int id) throws TechresHttpException;

	Material spUUpdateMaterial(Material material) throws TechresHttpException;

	void spUChangeStatusMaterial(int id) throws TechresHttpException;
	List<Material> spGMaterialsByCategoryId(String categoryId) throws TechresHttpException;

	void spUDeleteCategoryIdByMaterial(int id) throws TechresHttpException;

	void spUDeleteUnitIdByMaterial(int id) throws TechresHttpException;

	Material spUCreateMaterial(int userId, int categoryId, int unitId, String name, float wastageRate,
			float outStockAlertQuantity, double retailPrice, double costPrice) throws TechresHttpException;

	List<Material> spGFilterMaterials(int userId, String keyword, int status) throws TechresHttpException;


}
