package vn.aloapp.training.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.springboot.entity.Order;
import vn.aloapp.training.springboot.entity.OrderDetail;
import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.request.CRUDOrderRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.OrderDetailResponse;
import vn.aloapp.training.springboot.response.OrderResponse;
import vn.aloapp.training.springboot.service.OrderDetailService;
import vn.aloapp.training.springboot.service.OrderService;
import vn.aloapp.training.springboot.service.WarehouseSessionService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController extends BaseController{

	@Autowired
	OrderService orderService;

	@Autowired
	WarehouseSessionService warehouseSessionService;

	@Autowired
	OrderDetailService orderDetailService;


	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDOrderRequest request,
			@RequestHeader(value = "authorization")  String token) throws Exception {
		
		BaseResponse response = new BaseResponse();
		User usertoken = this.accessToken(token);
		
		Order order = orderService.spUCreateOrder(usertoken.getId(), 
												  request.getVat(), 
												  request.getDiscountPercent(),
												  request.getDiscountAmount(),
												  request.getDescription(),
												  new ObjectMapper().writeValueAsString(request.getOrderDetails())
												  );

		warehouseSessionService.spUExportWarehouseSessionFromOrder(order.getId());

		response.setData(new OrderResponse(order));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	@GetMapping(value = "/{id}/detail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getById(@PathVariable("id") long id,
			@RequestHeader(value = "authorization")  String token) throws Exception {
		BaseResponse response = new BaseResponse();
		
		User usertoken = this.accessToken(token);
		Order order = orderService.findByOrderByUserId(id, usertoken.getId());

		if (order == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Mã đơn hàng không tìm thấy");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		List<OrderDetail> orderDetails = orderDetailService.spGOrderDetailByOrderId(id);

		OrderResponse orderResponse = new OrderResponse(order);
		orderResponse.setOrderDetails(new OrderDetailResponse().mapToList(orderDetails));

		response.setData(orderResponse);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	
	@GetMapping(value = "/get-list", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getList(
			@RequestHeader(value = "authorization")  String token) throws Exception {
		
		User usertoken = this.accessToken(token);
		
		BaseResponse response = new BaseResponse();

		List<Order> orders = orderService.findOrdersByUserId(usertoken.getId());

		List<Long> listIdOrder = new ArrayList<>();

		orders.forEach(item -> listIdOrder.add(item.getId()));

		List<OrderResponse> orderResponses = new OrderResponse().mapToList(orders);

		List<OrderDetail> orderDetails = orderDetailService
				.spGOrderDetailByOrderIds(new ObjectMapper().writeValueAsString(listIdOrder));
		
		List<OrderDetailResponse> orderDetailResponses = new OrderDetailResponse().mapToList(orderDetails);

		orderResponses.forEach(order -> {
			order.setOrderDetails(orderDetailResponses.stream().filter(y -> y.getOrderId() == order.getId()).collect(Collectors.toList()));
		});

		response.setData(orderResponses);

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
