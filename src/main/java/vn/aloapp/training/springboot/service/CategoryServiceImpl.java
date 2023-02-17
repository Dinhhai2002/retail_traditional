package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.CategoryDao;
import vn.aloapp.training.springboot.entity.Category;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDao categoryDao;

	@Override
	public Category spUCreateCategory(int userId, String name, String prefixName, String normalizeName,
			String description, int sort) throws Exception {
		return categoryDao.spUCreateCategory(userId, name, prefixName, normalizeName, description, sort);
	}

	@Override
	public Category findOneByIdCategory(Integer id) throws Exception {
		return categoryDao.findOneByIdCategory(id);
	}

	@Override
	public void spUUpdateCategory(Category category) throws Exception {
		categoryDao.spUUpdateCategory(category);
	}

	@Override
	public List<Category> spGListCategorie(Integer userId, String keyword, Integer status) throws Exception {
		return categoryDao.spGListCategories(userId, keyword, status);
	}

	@Override
	public void deleteByIdCategory(Category category) throws Exception {
		categoryDao.deleteByIdCategory(category);
	}

}
