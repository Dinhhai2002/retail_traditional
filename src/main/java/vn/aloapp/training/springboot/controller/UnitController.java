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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.Unit;
import vn.aloapp.training.springboot.entity.UnitModel;
import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.request.CRUDUnitRequest;
import vn.aloapp.training.springboot.request.UnitRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.UnitResponse;
import vn.aloapp.training.springboot.service.MaterialService;
import vn.aloapp.training.springboot.service.UnitService;

/**
 * 
 * @author LENOVO
 *
 */
@RestController
@RequestMapping("/api/v1/units")
public class UnitController extends BaseController{

	@Autowired
	UnitService unitService;

	@Autowired
	MaterialService materialService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/list", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getList(
			@RequestParam(name = "status", defaultValue = "1", required = false) int status,
			@RequestHeader(value = "authorization")  String token)throws Exception {
		this.accessToken(token);
		BaseResponse response = new BaseResponse();
		response.setData(new UnitResponse().mapToList(unitService.spListUnit(status)));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	/**
	 * 
	 * @param unit
	 * @return
	 * @throws Exception
	 */

	// create Unit

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDUnitRequest unit,
			@RequestHeader(value = "authorization")  String token) throws Exception {
		
		BaseResponse response = new BaseResponse();
		User usertoken = this.accessToken(token);
		response.setData(
				new UnitResponse(unitService.spUCreateUnit(usertoken.getId(), unit.getName(), unit.getDescription())));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// update Unit

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/{id}/update", produces = {MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(@PathVariable("id") Integer id,
			@Valid @RequestBody CRUDUnitRequest unitRequest,
			@RequestHeader(value = "authorization") String token)throws Exception {
		BaseResponse response = new BaseResponse();
		
		User usertoken = this.accessToken(token);
		Unit unit = unitService.findOne(id);

		if (unit == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		
		unit.setUserId(usertoken.getId());
		unit.setName(unitRequest.getName());
		unit.setDescription(unitRequest.getDescription());

		unitService.spUUpdateUnit(unit);

		response.setData(new UnitResponse(unit));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// get Unit detail
 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/{id}/detail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getById(@PathVariable("id") Integer id,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();
		
		this.accessToken(token);
		Unit unit = unitService.findOne(id);

		if (unit == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		response.setData(new UnitResponse(unit));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// delete Unit

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/{id}/change-status", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> changeStatus(@PathVariable("id") int id, 
			@RequestBody UnitRequest unitRequest,
			@RequestHeader(value = "authorization") String token)
			throws Exception {
		BaseResponse response = new BaseResponse();
		this.accessToken(token);
		Unit unit = unitService.findOne(id);

		if (unit == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		List<UnitModel> unitModels = unitService.spGUnitByMaterial(id);

		if (unitRequest.getIsAccept() == 0 && unit.getStatus() == 1) {
			if (unitModels.stream().filter(x -> x.getLists().size() != 0) != null) {
				response.setStatus(HttpStatus.MULTIPLE_CHOICES);
				response.setMessageError(" Có nguyên liệu đang sử dụng đơn này , bạn có muốn tắt đơn vị này không ");
			}
		} else {

			if (unit.getStatus() == 1) {
				unit.setStatus(0);
				materialService.spUDeleteUnitIdByMaterial(id);
			} else {
				unit.setStatus(1);
			}
			unitService.update(unit);
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
