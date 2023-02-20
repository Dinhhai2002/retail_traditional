package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.Category;
import vn.aloapp.training.springboot.entity.CategoryModel;

public interface CategoryDao {

	Category spUCreateCategory(Category category) throws Exception;

	Category findOne(Integer id) throws Exception;

	void spUChangeStatusCategory(Integer id) throws Exception;

	Category spUUpdateCategory(Category category) throws Exception;
	public List<Category> spGCategories(int userId,String keyword,int status) throws Exception;

	List<CategoryModel> spGCategoriesV2(int id) throws Exception;
	
	void update(Category category);



}
