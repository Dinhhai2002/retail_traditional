package vn.aloapp.training.springboot.controller;

import java.util.List;

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

import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.entity.WarehouseSession;
import vn.aloapp.training.springboot.entity.WarehouseSessionDetail;
import vn.aloapp.training.springboot.request.CRUDWarehouseSessionRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.WarehouseSessionDetailResponse;
import vn.aloapp.training.springboot.response.WarehouseSessionResponse;
import vn.aloapp.training.springboot.service.WarehouseSessionDetailService;
import vn.aloapp.training.springboot.service.WarehouseSessionService;

@RestController
@RequestMapping("/api/v1/warehouse-sessions")
public class WarehouseSessionController extends BaseController {

	@Autowired
	WarehouseSessionService warehouseSessionService;

	@Autowired
	WarehouseSessionDetailService warehouseSessionDetailService;

	@GetMapping(value = "/{id}/detail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getById(@PathVariable("id") Long id,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		this.accessToken(token);
		WarehouseSession warehouseSession = warehouseSessionService.findOne(id);

		if (warehouseSession == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("không tìm thấy mã: " + id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		List<WarehouseSessionDetail> warehouseSessionDetails = warehouseSessionDetailService
				.spGWarehouseSessionDetailByWarehouseSessionId(warehouseSession.getId());

		List<WarehouseSessionDetailResponse> warehouseSessionDetailResponses = new WarehouseSessionDetailResponse()
				.mapToList(warehouseSessionDetails);

		WarehouseSessionResponse warehouseSessionResponse = new WarehouseSessionResponse(warehouseSession);
		warehouseSessionResponse.setList(warehouseSessionDetailResponses);

		response.setData(warehouseSessionResponse);

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create/import", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createWarehouseSession(@Valid @RequestBody CRUDWarehouseSessionRequest wrapper,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		User usertoken = this.accessToken(token);

		WarehouseSession warehouseSession = warehouseSessionService.importWarehouseSession(usertoken.getId(),
				wrapper.getDiscountPercent(), wrapper.getVat(), wrapper.getDiscountAmount(), wrapper.getDescription(),
				new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionDetails()));

		response.setData(new WarehouseSessionResponse(warehouseSession));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create/export", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> exportWarehouseSession(@Valid @RequestBody CRUDWarehouseSessionRequest wrapper,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();
		User usertoken = this.accessToken(token);

		WarehouseSession warehouseSession = warehouseSessionService.exportWarehouseSession(usertoken.getId(),
				wrapper.getDiscountPercent(), wrapper.getVat(), wrapper.getDiscountAmount(), wrapper.getDescription(),
				new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionDetails()));
		response.setData(new WarehouseSessionResponse(warehouseSession));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create/cancel", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> cancelWarehouseSession(@Valid @RequestBody CRUDWarehouseSessionRequest wrapper,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();
		User usertoken = this.accessToken(token);

		WarehouseSession warehouseSession = warehouseSessionService.cancelWarehouseSession(usertoken.getId(),
				wrapper.getDiscountPercent(), wrapper.getVat(), wrapper.getDiscountAmount(), wrapper.getDescription(),
				new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionDetails()));

		response.setData(new WarehouseSessionResponse(warehouseSession));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create/return", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> returnWarehouseSession(@Valid @RequestBody CRUDWarehouseSessionRequest wrapper,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();
		User usertoken = this.accessToken(token);

		WarehouseSession warehouseSession = warehouseSessionService.returnWarehouseSession(usertoken.getId(),
				wrapper.getDiscountPercent(), wrapper.getVat(), wrapper.getDiscountAmount(), wrapper.getDescription(),
				new ObjectMapper().writeValueAsString(wrapper.getWarehouseSessionDetails()));

		response.setData(new WarehouseSessionResponse(warehouseSession));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
