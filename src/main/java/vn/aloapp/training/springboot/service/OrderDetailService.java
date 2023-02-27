package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.OrderDetail;

public interface OrderDetailService {

	List<OrderDetail> spGOrderDetailByOrderId(long id) throws Exception;


	List<OrderDetail> spGOrderDetailByOrderIds(String orderId) throws Exception;

}
