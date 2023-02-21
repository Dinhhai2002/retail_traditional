package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.CategoryDao;
import vn.aloapp.training.springboot.entity.Category;
import vn.aloapp.training.springboot.entity.CategoryModel;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryDao categoryDao;

	@Override
	public Category spUCreateCategory(Category category) throws Exception {
		return categoryDao.spUCreateCategory(category);
	}

	@Override
	public Category findOne(Integer id) throws Exception {
		return categoryDao.findOne(id);
	}

	@Override
	public void spUChangeStatusCategory(Integer id) throws Exception {
		categoryDao.spUChangeStatusCategory(id);
		
	}

	@Override
	public Category spUUpdateCategory(Category category) throws Exception {
		return categoryDao.spUUpdateCategory(category);
	}

	@Override
	public List<Category> spGCategories(int userId, String keyword, int status) throws Exception {
		return categoryDao.spGCategories(userId, keyword, status);
	}

	@Override
	public List<CategoryModel> spGCategoriesV2(int id) throws Exception {
		return categoryDao.spGCategoriesV2(id);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);	
	}


}
