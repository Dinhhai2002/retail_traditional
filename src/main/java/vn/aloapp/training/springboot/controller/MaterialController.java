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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.Category;
import vn.aloapp.training.springboot.entity.Material;
import vn.aloapp.training.springboot.entity.Unit;
import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.request.CRUDMaterialRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.MaterialResponse;
import vn.aloapp.training.springboot.service.CategoryService;
import vn.aloapp.training.springboot.service.MaterialService;
import vn.aloapp.training.springboot.service.UnitService;

@RestController
@RequestMapping("/api/v1/materials")
public class MaterialController extends BaseController{

	@Autowired
	MaterialService materialService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UnitService unitService;
	
	

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getList(
			@RequestHeader(value = "authorization") String token,
			@RequestParam(name = "keyword", defaultValue = "", required = false) String keyword,
			@RequestParam(name = "status", defaultValue = "-1", required = false) int status) throws Exception {
		BaseResponse response = new BaseResponse();
		
		User usertoken = this.accessToken(token);
		List<Material> materials = materialService.spGFilterMaterials(usertoken.getId(), keyword, status);

		response.setData(new MaterialResponse().mapToList(materials));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDMaterialRequest request,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		User usertoken = this.accessToken(token);
		
		Category category = categoryService.findByUserIdAndCategoryIdAndStatus(usertoken.getId(), request.getCategoryId(), 1);
		
		if (category == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Mã danh mục không tìm thấy hoặc đã tắt.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		
		Unit unit = unitService.findByUserIdAndUnitIdAndStatus(usertoken.getId(), request.getUnitId(), 1);
		if (unit == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Mã đơn vị không tìm thấy hoặc đã tắt.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		

		response.setData(new MaterialResponse(materialService.spUCreateMaterial(
																				usertoken.getId(),
																				request.getCategoryId(),
																				request.getUnitId(),
																				request.getName(),
																				request.getWastageRate(),
																				request.getOutStockAlertQuantity(),
																				request.getRetailPrice(),
																				request.getCostPrice())));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/{id}/update", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(@PathVariable("id") Integer id,
			@Valid @RequestBody CRUDMaterialRequest request,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();
		
		User usertoken = this.accessToken(token);
		
		
		Material material = materialService.findByUserIdAndMaterialId(usertoken.getId(), id);
		
		if (material == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy nguyên liệu có mã là: "+ id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		Category category = categoryService.findByUserIdAndCategoryIdAndStatus(usertoken.getId(), request.getCategoryId(), 1);
		
		if (category == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Mã dang mục không tìm thấy hoặc đã tắt.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		Unit unit = unitService.findByUserIdAndUnitIdAndStatus(usertoken.getId(), request.getUnitId(), 1);
		
		if (unit == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Mã đơn vị không tìm thấy hoặc đã tắt.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}	

		material.setName(request.getName());
		material.setUserId(usertoken.getId());
		material.setCategoryId(request.getCategoryId());
		material.setUnitId(request.getUnitId());
		material.setWastageRate(request.getWastageRate());
		material.setOutStockAlertQuantity(request.getOutStockAlertQuantity());
		material.setRetailPrice(request.getRetailPrice());
		material.setCostPrice(request.getCostPrice());


		response.setData(new MaterialResponse(materialService.spUUpdateMaterial(material)));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}/detail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getById(@PathVariable("id") Integer id,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();
		

		User usertoken = this.accessToken(token);
		Material material = materialService.findByUserIdAndMaterialId(usertoken.getId(), id);

		if (material == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy nguyên liệu có mã là: "+ id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		response.setData(new MaterialResponse(material));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/{id}/change-status", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> changeStatus(@PathVariable("id") Integer id,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		User usertoken = this.accessToken(token);
		Material material = materialService.findByUserIdAndMaterialId(usertoken.getId(), id);

		if (material == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy nguyên liệu có mã là: "+ id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		materialService.spUChangeStatusMaterial(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
