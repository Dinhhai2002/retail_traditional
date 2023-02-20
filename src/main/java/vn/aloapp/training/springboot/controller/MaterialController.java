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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.Material;
import vn.aloapp.training.springboot.request.CRUDMaterialRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.MaterialResponse;
import vn.aloapp.training.springboot.service.MaterialService;

@RestController
@RequestMapping("/api/v1/materials")
public class MaterialController {

	@Autowired
	MaterialService materialService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/list", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getList(
			@RequestParam(name = "status", defaultValue = "1", required = false) int status) throws Exception {
		BaseResponse response = new BaseResponse();
		List<Material> list = materialService.spGListMaterial(status);

		response.setData(new MaterialResponse().mapToList(list));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDMaterialRequest request) throws Exception {
		BaseResponse response = new BaseResponse();

		Material material = new Material();
		material.setName(request.getName());
		material.setAvatar(request.getAvatar());
		material.setAvatarThumb(request.getAvatarThumb());
		material.setUserId(request.getUserId());
		material.setCategoryId(request.getCategoryId());
		material.setUnitId(request.getUnitId());
		material.setWastageRate(request.getWastageRate());
		material.setOutStockAlertQuantity(request.getOutStockAlertQuantity());
		material.setRetailPrice(request.getRetailPrice());
		material.setCostPrice(request.getCostPrice());

		response.setData(new MaterialResponse(materialService.spUCreateMaterial(material)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/{id}/update", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(@PathVariable("id") Integer id,
			@Valid @RequestBody CRUDMaterialRequest request) throws Exception {
		BaseResponse response = new BaseResponse();
		Material material = materialService.findOne(id);

		if (material == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		material.setName(request.getName());
		material.setAvatar(request.getAvatar());
		material.setAvatarThumb(request.getAvatarThumb());
		material.setUserId(request.getUserId());
		material.setCategoryId(request.getCategoryId());
		material.setUnitId(request.getUnitId());
		material.setWastageRate(request.getWastageRate());
		material.setOutStockAlertQuantity(request.getOutStockAlertQuantity());
		material.setRetailPrice(request.getRetailPrice());
		material.setCostPrice(request.getCostPrice());

		materialService.spUUpdateMaterial(material);

		response.setData(new MaterialResponse(material));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/{id}/detail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getById(@PathVariable("id") Integer id) throws Exception {
		BaseResponse response = new BaseResponse();
		Material material = materialService.findOne(id);

		if (material == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		response.setData(new MaterialResponse(material));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/{id}/change-status", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> changeStatus(@PathVariable("id") Integer id) throws Exception {
		BaseResponse response = new BaseResponse();

		Material material = materialService.findOne(id);

		if (material == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		materialService.spUChangeStatusMaterial(id);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
