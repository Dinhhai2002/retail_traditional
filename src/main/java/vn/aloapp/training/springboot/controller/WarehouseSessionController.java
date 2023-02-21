package vn.aloapp.training.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.WarehouseSession;
import vn.aloapp.training.springboot.entity.WarehouseSessionDetail;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.WarehouseSessionDetailResponse;
import vn.aloapp.training.springboot.response.WarehouseSessionResponse;
import vn.aloapp.training.springboot.service.WarehouseSessionDetailService;
import vn.aloapp.training.springboot.service.WarehouseSessionService;

@RestController
@RequestMapping("/api/v1/warehouse-sessions")
public class WarehouseSessionController {
	
	@Autowired
	WarehouseSessionService warehouseSessionService;
	
	@Autowired
	WarehouseSessionDetailService warehouseSessionDetailService; 
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/{id}/detail", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getById(@PathVariable("id") Long id) throws Exception {
		BaseResponse response = new BaseResponse();
		WarehouseSession warehouseSession = warehouseSessionService.findOne(id);

		if (warehouseSession == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		List<WarehouseSessionDetail> warehouseSessionDetails = warehouseSessionDetailService.spGWarehouseSessionDetailByWarehouseSessionId(warehouseSession.getId());

		List<WarehouseSessionDetailResponse> warehouseSessionDetailResponses = new WarehouseSessionDetailResponse().mapToList(warehouseSessionDetails);
		
		WarehouseSessionResponse warehouseSessionResponse = new WarehouseSessionResponse(warehouseSession);
		warehouseSessionResponse.getList().setList(warehouseSessionDetailResponses);
		
		response.setData(warehouseSessionResponse);

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
