package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Material;
import vn.aloapp.training.springboot.entity.Unit;

@Repository("materialDao")
@SuppressWarnings("unchecked")
public class MaterialDaoImpl extends AbstractDao<Integer, Material> implements MaterialDao {

	@Override
	public Material spUCreateMaterial(int userId, int categoryId, int unitId, String name, float wastageRate,
			float outStockAlertQuantity, double retailPrice, double costPrice) throws TechresHttpException {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_material", Material.class)

				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("unitId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("wastageRate", Float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("outStockAlertQuantity", Float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("retailPrice", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("costPrice", Double.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);


		query.setParameter("userId", userId);
		query.setParameter("categoryId", categoryId);
		query.setParameter("unitId", unitId);
		query.setParameter("_name", name);
		query.setParameter("wastageRate", wastageRate);
		query.setParameter("outStockAlertQuantity", outStockAlertQuantity);
		query.setParameter("retailPrice", retailPrice);
		query.setParameter("costPrice", costPrice);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Material) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new TechresHttpException(messageError);
		}
	}

	@Override
	public Material findByUserIdAndMaterialId(int userId, int id) throws TechresHttpException {
		CriteriaBuilder builder = this.getBuilder();
		CriteriaQuery<Material> query = builder.createQuery(Material.class);
		Root<Material> root = query.from(Material.class);
		query.where(builder.and(builder.equal(root.get("id"), id), 
					builder.equal(root.get("userId"), userId)));
		
		return this.getSession().createQuery(query).uniqueResult();
	}

	@Override
	public Material spUUpdateMaterial(Material material) throws TechresHttpException {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_update_material", Material.class)

				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("unitId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("wastageRate", Float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("outStockAlertQuantity", Float.class, ParameterMode.IN)
				.registerStoredProcedureParameter("retailPrice", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("costPrice", Double.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", material.getUserId());
		query.setParameter("categoryId", material.getCategoryId());
		query.setParameter("unitId", material.getUnitId());
		query.setParameter("_id", material.getId());
		query.setParameter("_name", material.getName());
		query.setParameter("wastageRate", material.getWastageRate());
		query.setParameter("outStockAlertQuantity", material.getOutStockAlertQuantity());
		query.setParameter("retailPrice", material.getRetailPrice());
		query.setParameter("costPrice", material.getCostPrice());

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Material) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new TechresHttpException(messageError);
		}
	}

	@Override
	public void spUChangeStatusMaterial(int id) throws TechresHttpException {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_change_status_material", Material.class)
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
			throw new TechresHttpException(messageError);
		}

	}

	@Override
	public List<Material> spGMaterialsByCategoryId(String categoryId) throws TechresHttpException {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_material_by_category", Material.class)

				.registerStoredProcedureParameter("categoryId", String.class, ParameterMode.IN)		
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("categoryId", categoryId);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return query.getResultList();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new TechresHttpException(messageError);
		}
	}

	@Override
	public void spUDeleteCategoryIdByMaterial(int categoryId) throws TechresHttpException {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_delete_category_id_by_material", Material.class)
				.registerStoredProcedureParameter("categoryId", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("categoryId", categoryId);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			break;
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new TechresHttpException(messageError);
		}
		

	}

	@Override
	public void spUDeleteUnitIdByMaterial(int id) throws TechresHttpException {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_delete_unit_id_by_material", Material.class)
				.registerStoredProcedureParameter("unitId", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("unitId", id);

		
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			break;
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new TechresHttpException(messageError);
		}
		
	}

	@Override
	public List<Material> spGFilterMaterials(int userId, String keyword, int status) throws TechresHttpException {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_filter_materials", Material.class)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_keyword", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_status", Integer.class, ParameterMode.IN)
				

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", userId);
		query.setParameter("_keyword", keyword);
		query.setParameter("_status", status);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return query.getResultList();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new TechresHttpException(messageError);
		}
	}

}
