package vn.aloapp.training.springboot.service;


import java.util.List;

import vn.aloapp.training.springboot.entity.Order;
import vn.aloapp.training.springboot.request.CRUDOrderRequest;

public interface OrderService {

	Order findByOrderByUserId(long id, int userId) throws Exception;

	List<Order> findOrdersByUserId(int userId) throws Exception;

	Order spUCreateOrder(int id, double vat, double discountPercent, double discountAmount, String description,
			String orderDetails) throws Exception;

}
