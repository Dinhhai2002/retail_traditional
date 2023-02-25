package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.WarehouseSession;
import vn.aloapp.training.springboot.entity.Report;
import vn.aloapp.training.springboot.request.CRUDWarehouseSessionRequest;

@Repository("warehouseSessionDao")
public class WarehouseSessionDaoImpl extends AbstractDao<Long, WarehouseSession> implements WarehouseSessionDao{

	@SuppressWarnings("deprecation")
	@Override
	public WarehouseSession findOne(Long id) throws Exception {
		return (WarehouseSession) this.getSession().createCriteria(WarehouseSession.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public WarehouseSession importWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_warehouse_session", WarehouseSession.class)

				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_vat", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountAmount", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("warehouseSessionDetail", String.class, ParameterMode.IN)
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", wrapper.getUserId());
		query.setParameter("discountPercent", wrapper.getDiscountPercent());
		query.setParameter("_vat", wrapper.getVat());
		query.setParameter("discountAmount", wrapper.getDiscountAmount());
		query.setParameter("_description", wrapper.getDescription());
		query.setParameter("warehouseSessionDetail",new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionDetails()));

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (WarehouseSession) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public WarehouseSession exportWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_export_warehouse_session", WarehouseSession.class)

				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_vat", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountAmount", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("warehouseSessionDetail", String.class, ParameterMode.IN)
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", wrapper.getUserId());
		query.setParameter("discountPercent", wrapper.getDiscountPercent());
		query.setParameter("_vat", wrapper.getVat());
		query.setParameter("discountAmount", wrapper.getDiscountAmount());
		query.setParameter("_description", wrapper.getDescription());
		query.setParameter("warehouseSessionDetail",new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionDetails()));

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (WarehouseSession) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public WarehouseSession cancelWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_cancel_warehouse_session", WarehouseSession.class)

				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_vat", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountAmount", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("warehouseSessionDetail", String.class, ParameterMode.IN)
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", wrapper.getUserId());
		query.setParameter("discountPercent", wrapper.getDiscountPercent());
		query.setParameter("_vat", wrapper.getVat());
		query.setParameter("discountAmount", wrapper.getDiscountAmount());
		query.setParameter("_description", wrapper.getDescription());
		query.setParameter("warehouseSessionDetail",new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionDetails()));

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (WarehouseSession) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public WarehouseSession returnWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_return_warehouse_session", WarehouseSession.class)

				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_vat", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountAmount", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("warehouseSessionDetail", String.class, ParameterMode.IN)
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", wrapper.getUserId());
		query.setParameter("discountPercent", wrapper.getDiscountPercent());
		query.setParameter("_vat", wrapper.getVat());
		query.setParameter("discountAmount", wrapper.getDiscountAmount());
		query.setParameter("_description", wrapper.getDescription());
		query.setParameter("warehouseSessionDetail",new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionDetails()));

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (WarehouseSession) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	

}
