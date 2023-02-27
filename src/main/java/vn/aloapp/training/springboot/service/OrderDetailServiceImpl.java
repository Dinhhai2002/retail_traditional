package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.OrderDetailDao;
import vn.aloapp.training.springboot.entity.OrderDetail;

@Service("orderDetailService")
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	OrderDetailDao orderDetailDao;
	@Override
	public List<OrderDetail> spGOrderDetailByOrderId(long orderId) throws Exception {
		
		return orderDetailDao.spGOrderDetailByOrderId(orderId);
	}
	@Override
	public List<OrderDetail> spGOrderDetailByOrderIds(String orderId) throws Exception {
		return orderDetailDao.spGOrderDetailByOrderIds(orderId);
	}

}
