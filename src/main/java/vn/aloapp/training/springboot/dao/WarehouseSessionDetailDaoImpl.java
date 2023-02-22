package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.WarehouseSessionDetail;

@Repository("warehouseSessionDetailDao")
public class WarehouseSessionDetailDaoImpl extends AbstractDao<Long, WarehouseSessionDetail> implements WarehouseSessionDetailDao{

	@Override
	public List<WarehouseSessionDetail> spGWarehouseSessionDetailByWarehouseSessionId(long warehouseSessionId) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_warehouse_session_detail_by_warehouse_session_id", WarehouseSessionDetail.class)

				.registerStoredProcedureParameter("warehouseSessionId", Long.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("warehouseSessionId", warehouseSessionId);

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
