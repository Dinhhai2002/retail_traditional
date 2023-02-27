package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.OrderDetail;

/**
 * 
 * @author Dung Nguyen
 *
 */
@Repository("orderDetailDao")
public class OrderDetailDaoImpl extends AbstractDao<Long, OrderDetail> implements OrderDetailDao {

	@Override
	public List<OrderDetail> spGOrderDetailByOrderId(long orderId) throws Exception {
		CriteriaQuery<OrderDetail> criteria = this.getBuilder().createQuery(OrderDetail.class);
		Root<OrderDetail> root = criteria.from(OrderDetail.class);

		criteria.select(root).where(this.getBuilder().equal(root.get("orderId"), orderId));
		return this.getSession().createQuery(criteria).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderDetail> spGOrderDetailByOrderIds(String orderId) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_order_detail_by_order_ids", OrderDetail.class)

				.registerStoredProcedureParameter("orderIds", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("orderIds", orderId);

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

}
