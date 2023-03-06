package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.Category;
import vn.aloapp.training.springboot.response.CategoryModel;
import vn.aloapp.training.springboot.response.CategoryResponse;

public interface CategoryDao {

	Category spUCreateCategory(int userId, String name, int sort, String description) throws Exception;

	Category findByUserIdAndCategoryId(int userId, int id) throws Exception;

	void spUChangeStatusCategory(Integer id) throws Exception;

	Category spUUpdateCategory(Category category) throws Exception;

	public List<Category> spGCategories(int userId, String keyword, int status) throws Exception;

	List<CategoryModel> spGCategoriesV2(int userId, int id) throws Exception;

	void update(Category category) throws Exception;

	List<Category> findByCategoryByUserId(int userId) throws Exception;

	CategoryModel spGCategoriesByMaterial(int userId, int id) throws Exception;

	List<Category> spGFilterCategories(int userId, String keyword, int sort, int status) throws Exception;

	Category findByUserIdAndCategoryIdAndStatus(int userId, int categoryId, int status) throws Exception;

}
