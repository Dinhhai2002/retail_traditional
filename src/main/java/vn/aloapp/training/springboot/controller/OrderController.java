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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.springboot.request.CRUDOrderRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.OrderResponse;
import vn.aloapp.training.springboot.service.OrderDetailService;
import vn.aloapp.training.springboot.service.OrderService;
import vn.aloapp.training.springboot.service.WarehouseSessionService;
import vn.aloapp.training.springboot.entity.Order;
import vn.aloapp.training.springboot.entity.OrderDetail;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	WarehouseSessionService warehouseSessionService;

	@Autowired
	OrderDetailService orderDetailService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDOrderRequest request) throws Exception {

		BaseResponse response = new BaseResponse();
		Order order = orderService.spUCreateOrder(request);

		warehouseSessionService.spUExportWarehouseSessionFromOrder(order.getId());

		response.setData(new OrderResponse(order));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/{id}/detail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getById(@PathVariable("id") long id) throws Exception {
		BaseResponse response = new BaseResponse();
		Order order = orderService.findOne(id);

		if (order == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		List<OrderDetail> orderDetails = orderDetailService.spGOrderDetailByOrderId(id);

		OrderResponse orderResponse = new OrderResponse(order);
		orderResponse.getOrderDetails().setList(orderDetails);

		response.setData(orderResponse);

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/get-list", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getList() throws Exception {
		BaseResponse response = new BaseResponse();

		List<Order> orders = orderService.findAll();

		List<Long> listIdOrder = new ArrayList<>();

		orders.forEach(item -> listIdOrder.add(item.getId()));

		List<OrderResponse> orderResponses = new OrderResponse().mapToList(orders);

		List<OrderDetail> orderDetails = orderDetailService
				.spGOrderDetailByOrderIds(new ObjectMapper().writeValueAsString(listIdOrder));

		orderResponses.forEach(order -> {

			order.getOrderDetails().setList(
					orderDetails.stream().filter(y -> y.getOrderId() == order.getId()).collect(Collectors.toList()));
		});

		response.setData(orderResponses);

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}

}
