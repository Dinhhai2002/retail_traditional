package vn.aloapp.training.springboot.service;


import java.util.List;

import vn.aloapp.training.springboot.entity.Order;
import vn.aloapp.training.springboot.request.CRUDOrderRequest;

public interface OrderService {

	Order spUCreateOrder(CRUDOrderRequest request) throws Exception;

	Order findOne(long id) throws Exception;

	List<Order> findAll() throws Exception;

}