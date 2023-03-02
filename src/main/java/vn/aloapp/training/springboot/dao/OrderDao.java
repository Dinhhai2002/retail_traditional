package vn.aloapp.training.springboot.dao;


import java.util.List;

import vn.aloapp.training.springboot.entity.Order;
import vn.aloapp.training.springboot.request.CRUDOrderRequest;

public interface OrderDao {

	Order spUCreateOrder(int id, double vat, double discountPercent, double discountAmount, String description,
			String orderDetails) throws Exception;

	Order findOne(long id)  throws Exception;

	List<Order> findAll() throws Exception;

}
