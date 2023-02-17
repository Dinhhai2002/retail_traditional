package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.Category;

public interface CategoryDao {

	Category spUCreateCategory(int userId, String name, String prefixName, String normalizeName, String description,
			int sort) throws Exception;

	Category findOneByIdCategory(Integer id) throws Exception;

	void spUUpdateCategory(Category category) throws Exception;

	List<Category> spGListCategories(Integer userId, String keyword, Integer status) throws Exception;

	void deleteByIdCategory(Category category) throws Exception;



}
