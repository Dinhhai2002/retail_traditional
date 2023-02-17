package vn.aloapp.training.springboot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.aloapp.training.springboot.entity.Category;


@Repository("categoryDao")
@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao{

	@Override
	public Category spUCreateCategory(int userId, String name, String prefixName, String normalizeName,
			String description, int sort) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findOneByIdCategory(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void spUUpdateCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> spGListCategories(Integer userId, String keyword, Integer status) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByIdCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
