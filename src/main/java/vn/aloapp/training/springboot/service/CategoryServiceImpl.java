package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.CategoryDao;
import vn.aloapp.training.springboot.entity.Category;
import vn.aloapp.training.springboot.response.CategoryModel;
import vn.aloapp.training.springboot.response.CategoryResponse;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public Category spUCreateCategory(int userId, String name, int sort, String description) throws Exception {
		return categoryDao.spUCreateCategory(userId, name, sort, description);
	}

	@Override
	public Category findByUserIdAndCategoryId(int userId, int id) throws Exception {
		return categoryDao.findByUserIdAndCategoryId(userId, id);
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
	public List<CategoryModel> spGCategoriesV2(int userId, int id) throws Exception {
		return categoryDao.spGCategoriesV2(userId, id);
	}

	@Override
	public void update(Category category) throws Exception {
		categoryDao.update(category);
	}

	@Override
	public List<Category> findByCategoryByUserId(int userId) throws Exception {
		return categoryDao.findByCategoryByUserId(userId);
	}

	@Override
	public CategoryModel spGCategoriesByMaterial(int userId, int id) throws Exception {
		return categoryDao.spGCategoriesByMaterial(userId, id);
	}

	@Override
	public List<Category> spGFilterCategories(int userId, String keyword, int sort, int status)
			throws Exception {
		return categoryDao.spGFilterCategories(userId, keyword, sort, status);
	}

	@Override
	public Category findByUserIdAndCategoryIdAndStatus(int userId, int categoryId, int status) throws Exception {
		return categoryDao.findByUserIdAndCategoryIdAndStatus(userId, categoryId, status);
	}

}
