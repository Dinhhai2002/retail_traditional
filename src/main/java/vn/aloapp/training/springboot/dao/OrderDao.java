package vn.aloapp.training.springboot.dao;


import java.util.List;

import vn.aloapp.training.springboot.entity.Order;
import vn.aloapp.training.springboot.request.CRUDOrderRequest;

public interface OrderDao {

	Order spUCreateOrder(CRUDOrderRequest request) throws Exception;

	Order findOne(long id)  throws Exception;

	List<Order> findAll() throws Exception;

}
