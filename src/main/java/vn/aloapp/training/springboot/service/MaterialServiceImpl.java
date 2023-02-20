package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.MaterialDao;
import vn.aloapp.training.springboot.entity.Material;

@Service("materialService")
@Transactional
public class MaterialServiceImpl implements MaterialService{
	
	@Autowired
	MaterialDao dao;

	@Override
	public Material spUCreateMaterial(Material material) throws Exception {
		return dao.spUCreateMaterial(material);
	}

	@Override
	public Material findOne(Integer id) throws Exception {
		return dao.findOne(id);
	}

	@Override
	public Material spUUpdateMaterial(Material material) throws Exception {
		return dao.spUUpdateMaterial(material);
	}

	@Override
	public List<Material> spGListMaterial( Integer status) throws Exception {
		return dao.spGListMaterial(status);
	}

	@Override
	public void spUChangeStatusMaterial(int id) throws Exception {
		dao.spUChangeStatusMaterial(id);
		
	}

	@Override
	public List<Material> spGMaterialsByCategoryId(String categoryId) throws Exception {
		return dao.spGMaterialsByCategoryId(categoryId);
	}

	@Override
	public void spUDeleteCategoryIdByMaterial(int id) throws Exception {
		 dao.spUDeleteCategoryIdByMaterial(id);
	}

	@Override
	public void spUDeleteUnitIdByMaterial(int id) throws Exception {
		dao.spUDeleteUnitIdByMaterial(id);
		
	}

	

	

}
