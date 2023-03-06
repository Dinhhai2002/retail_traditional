package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.Restrictions;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Material;
import vn.aloapp.training.springboot.entity.Order;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Long, Order> implements OrderDao{

	@SuppressWarnings("unchecked")
	@Override
	public Order spUCreateOrder(int userId, double vat, double discountPercent, double discountAmount, String description,
			String orderDetails) throws Exception {
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

		query.setParameter("userId", userId);
		query.setParameter("_vat", vat);
		query.setParameter("discountPercent", discountPercent);
		query.setParameter("discountAmount", discountAmount);
		query.setParameter("_description", description);
		query.setParameter("orderDetails", orderDetails);

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
	public Order findByOrderByUserId(long id, int userId) throws Exception {
		CriteriaBuilder builder = this.getBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		query.where(builder.and(builder.equal(root.get("id"), id), 
					builder.equal(root.get("userId"), userId)));
	
		return this.getSession().createQuery(query).uniqueResult();
	}

	@Override
	public List<Order> findOrdersByUserId(int userId) throws Exception {
		
		CriteriaBuilder builder = this.getBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
		query.where(builder.equal(root.get("userId"), userId));

		
		return this.getSession().createQuery(query).getResultList();

	}

}
