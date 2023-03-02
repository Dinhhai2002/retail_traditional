package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Category;
import vn.aloapp.training.springboot.entity.CategoryModel;

@Repository("categoryDao")
@SuppressWarnings("unchecked")
public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao {

	@Override
	public Category spUCreateCategory(Category category) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_category", Category.class)

				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_sort", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_name", category.getName());
		query.setParameter("userId", category.getUserId());
		query.setParameter("_sort", category.getSort());
		query.setParameter("_description", category.getDescription());

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Category) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public Category findOne(Integer id) throws Exception {
		return (Category) this.getSession().createCriteria(Category.class).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void spUChangeStatusCategory(Integer id) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_change_status_category", Category.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_id", id);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			break;
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}

	}

	@Override
	public Category spUUpdateCategory(Category category) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_update_category", Category.class)

				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_sort", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_id", category.getId());
		query.setParameter("_name", category.getName());
		query.setParameter("userId", category.getUserId());
		query.setParameter("_sort", category.getSort());
		query.setParameter("_description", category.getDescription());

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Category) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public List<Category> spGCategories(int userId, String keyword, int status) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_categories", Category.class)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_status", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("keySearch", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", userId);
		query.setParameter("_status", status);
		query.setParameter("keySearch", keyword);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return query.getResultList();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public List<CategoryModel> spGCategoriesV2(int id) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_categories_v2", CategoryModel.class)
				.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("categoryId", id);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return query.getResultList();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public void update(Category category) {
		this.getSession().update(category);
	}
}
