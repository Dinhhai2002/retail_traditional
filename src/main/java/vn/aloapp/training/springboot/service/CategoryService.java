package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.Category;

public interface CategoryService {

	Category spUCreateCategory(int userId, String name, String prefixName, String normalizeName,
			String description, int sort) throws Exception;

	Category findOneByIdCategory(Integer id) throws Exception;

	void spUUpdateCategory(Category category) throws Exception;

	List<Category> spGListCategorie(Integer userId, String keyword, Integer status) throws Exception;

	void deleteByIdCategory(Category category) throws Exception;


}
