package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.dao.MaterialDao;
import vn.aloapp.training.springboot.entity.Material;

@Service("materialService")
@Transactional
public class MaterialServiceImpl implements MaterialService{
	
	@Autowired
	MaterialDao dao;

	@Override
	public Material spUCreateMaterial(int userId, int categoryId, int unitId, String name, float wastageRate,
			float outStockAlertQuantity, double retailPrice, double costPrice) throws TechresHttpException {
		return dao.spUCreateMaterial(userId, categoryId, unitId, name, wastageRate, outStockAlertQuantity, retailPrice, costPrice);
	}

	@Override
	public Material findByUserIdAndMaterialId(int userId, int id) throws TechresHttpException {
		return dao.findByUserIdAndMaterialId(userId, id);
	}

	@Override
	public Material spUUpdateMaterial(Material material) throws TechresHttpException {
		return dao.spUUpdateMaterial(material);
	}

	@Override
	public void spUChangeStatusMaterial(int id) throws TechresHttpException {
		dao.spUChangeStatusMaterial(id);
		
	}

	@Override
	public List<Material> spGMaterialsByCategoryId(String categoryId) throws TechresHttpException {
		return dao.spGMaterialsByCategoryId(categoryId);
	}

	@Override
	public void spUDeleteCategoryIdByMaterial(int id) throws TechresHttpException {
		 dao.spUDeleteCategoryIdByMaterial(id);
	}

	@Override
	public void spUDeleteUnitIdByMaterial(int id) throws TechresHttpException {
		dao.spUDeleteUnitIdByMaterial(id);
		
	}

	@Override
	public List<Material> spGFilterMaterials(int userId, String keyword, int status) throws TechresHttpException {
		return dao.spGFilterMaterials(userId, keyword, status);
	}

	

	

}
