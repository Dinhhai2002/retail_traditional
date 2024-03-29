package vn.aloapp.training.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.OrderDao;
import vn.aloapp.training.springboot.entity.Order;
import vn.aloapp.training.springboot.request.CRUDOrderRequest;

@Service("orderService")
@Transactional(rollbackFor = Error.class)
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;

	@Override
	public Order spUCreateOrder(int id, double vat, double discountPercent, double discountAmount, String description,
			String orderDetails) throws Exception {
		return orderDao.spUCreateOrder(id, vat, discountPercent, discountAmount, description, orderDetails);
	}

	@Override
	public Order findByOrderByUserId(long id, int userId) throws Exception {
		return orderDao.findByOrderByUserId(id, userId);
	}

	@Override
	public List<Order> findOrdersByUserId(int userId) throws Exception {
		return orderDao.findOrdersByUserId(userId);
	}

}
