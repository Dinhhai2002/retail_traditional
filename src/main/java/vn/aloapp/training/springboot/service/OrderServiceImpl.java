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
	public Order spUCreateOrder(CRUDOrderRequest request) throws Exception {
		return orderDao.spUCreateOrder(request);
	}

	@Override
	public Order findOne(long id) throws Exception {
		return orderDao.findOne(id);
	}

	@Override
	public List<Order> findAll() throws Exception {
		return orderDao.findAll();
	}

}