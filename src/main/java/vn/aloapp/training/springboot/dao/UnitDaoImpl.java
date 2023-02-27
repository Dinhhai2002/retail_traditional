package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Unit;
import vn.aloapp.training.springboot.entity.UnitModel;

@Repository("unitDao")
@SuppressWarnings("unchecked")
public class UnitDaoImpl extends AbstractDao<Integer, Unit> implements UnitDao{

	@Override
	public Unit spUCreateUnit(int userId, String name, String description) throws TechresHttpException {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_create_unit", Unit.class)
				
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("userId", userId);
		query.setParameter("_name", name);
		query.setParameter("_description", description);
		

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (Unit) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);		}
	}


	@SuppressWarnings("deprecation")
	@Override
	public Unit findOne(Integer id) throws Exception {
		return (Unit) this.getSession().createCriteria(Unit.class).add(Restrictions.eq("id", id)).uniqueResult();
	}


	@Override
	public Unit spUUpdateUnit(Unit unit) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_update_unit", Unit.class)
				
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_name", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("_id", unit.getId());
		query.setParameter("userId", unit.getUserId());
		query.setParameter("_name", unit.getName());
		query.setParameter("_description", unit.getDescription());
		

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			 return (Unit) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
		
	}


	@Override
	public void spUChangeStatusUnit(int status, Integer id) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_change_status_unit", Unit.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_status", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("_id", id);
		query.setParameter("_status", status);
		
		query.getOutputParameterValue("status_code");
		query.getOutputParameterValue("message_error").toString();
		
	}


	@Override
	public List<Unit> spListUnit(int status) throws TechresHttpException {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_list_unit", Unit.class)

				.registerStoredProcedureParameter("_status", Integer.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

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


	@Override
	public List<UnitModel> spGUnitByMaterial(int id) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_unit_by_material", UnitModel.class)
				.registerStoredProcedureParameter("unitId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("unitId", id);

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
	public void update(Unit unit) {
		this.getSession().update(unit);
	}

}
