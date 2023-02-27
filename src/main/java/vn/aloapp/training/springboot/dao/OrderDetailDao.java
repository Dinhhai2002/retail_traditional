package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.OrderDetail;

public interface OrderDetailDao {

	List<OrderDetail> spGOrderDetailByOrderId(long orderId) throws Exception;

	List<OrderDetail> spGOrderDetailByOrderIds(String orderId) throws Exception;

}
