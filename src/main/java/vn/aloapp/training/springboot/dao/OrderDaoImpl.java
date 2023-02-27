package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Order;
import vn.aloapp.training.springboot.request.CRUDOrderRequest;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Long, Order> implements OrderDao{

	@Override
	public Order spUCreateOrder(CRUDOrderRequest request) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_u_create_order", Order.class)

				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_vat", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountPercent", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("discountAmount", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_description", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("orderDetails", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("userId", request.getUserId());
		query.setParameter("_vat", request.getVat());
		query.setParameter("discountPercent", request.getDiscountPercent());
		query.setParameter("discountAmount", request.getDiscountAmount());
		query.setParameter("_description", request.getDescription());
		query.setParameter("orderDetails", new ObjectMapper().writeValueAsString(request.getOrderDetails()));

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();
		
		
		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return  (Order) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public Order findOne(long id) throws Exception {
		return (Order) this.getSession().createCriteria(Order.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Order> findAll() throws Exception {
		
		CriteriaQuery<Order> criteria = this.getBuilder().createQuery(Order.class);
		Root<Order> root = criteria.from(Order.class);

		criteria.select(root);
		return this.getSession().createQuery(criteria).getResultList();

	}

}
