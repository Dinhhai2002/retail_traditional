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
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.Category;
import vn.aloapp.training.springboot.entity.CategoryModel;
import vn.aloapp.training.springboot.request.CRUDCategoryRequest;
import vn.aloapp.training.springboot.request.CategoryRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.CategoryResponse;
import vn.aloapp.training.springboot.service.CategoryService;
import vn.aloapp.training.springboot.service.MaterialService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	MaterialService materialService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDCategoryRequest request) throws Exception {
		BaseResponse response = new BaseResponse();

		Category category = new Category();

		category.setName(request.getName());
		category.setUserId(request.getUserId());
		category.setSort(request.getSort());
		category.setDescription(request.getDescription());

		response.setData(new CategoryResponse(categoryService.spUCreateCategory(category)));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// update Unit

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/{id}/update", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(@PathVariable("id") Integer id,
			@Valid @RequestBody CRUDCategoryRequest request) throws Exception {
		BaseResponse response = new BaseResponse();
		Category category = categoryService.findOne(id);

		if (category == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		category.setName(request.getName());
		category.setUserId(request.getUserId());
		category.setSort(request.getSort());
		category.setDescription(request.getDescription());
		response.setData(new CategoryResponse(categoryService.spUUpdateCategory(category)));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// get list Unit and filter

	// get Unit detail
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/{id}/detail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getById(@PathVariable("id") Integer id) throws Exception {
		BaseResponse response = new BaseResponse();
		Category category = categoryService.findOne(id);

		if (category == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		response.setData(new CategoryResponse(category));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}

	// delete Unit

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(value = "/{id}/change-status", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> changeStatus(@PathVariable("id") int id,
			@RequestBody CategoryRequest categoryRequest) throws Exception {
		BaseResponse response = new BaseResponse();

		Category category = categoryService.findOne(id);

		if (category == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(HttpStatus.BAD_REQUEST.name());
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}

		List<CategoryModel> categoryModel = categoryService.spGCategoriesV2(id);

		if (categoryRequest.getIsAccept() == 0 && category.getStatus() == 1) {
			if (categoryModel.stream().filter(x -> x.getLists().size() != 0) != null) {
				response.setStatus(HttpStatus.MULTIPLE_CHOICES);
				response.setMessageError(
						" Có nguyên liệu đang nằm trong danh mục này , bạn có muốn tắt danh mục này không ");
			}
		} else {

			if (category.getStatus() == 1) {
				category.setStatus(0);
				materialService.spUDeleteCategoryIdByMaterial(id);
			} else {
				category.setStatus(1);
			}
			categoryService.update(category);
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/get-list", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getListTreeV2() throws Exception {
		BaseResponse response = new BaseResponse();
		List<CategoryModel> categories = categoryService.spGCategoriesV2(1);

		response.setData(categories);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@GetMapping(value = "/list-tree", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> getListTree() throws Exception {
//		BaseResponse response = new BaseResponse();
//		List<Category> categories = categoryService.spGCategories(-1, "", -1);
//		List<Integer> ListCategories = new ArrayList<>();
//		List<Integer> listmaterial = new ArrayList<>();
//
//		categories.forEach(x -> ListCategories.add(x.getId()));
//
//		List<Material> materials = materialService
//				.spGMaterialsByCategoryId(new ObjectMapper().writeValueAsString(ListCategories));
//		materials.forEach(x -> listmaterial.add(x.getId()));
//		List<CategoryResponse> categoryResponse = new CategoryResponse().mapToList(categories);
//
//		List<MaterialResponse> materialResponse = new MaterialResponse().mapToList(materials);
//
//		categoryResponse.stream().map(x -> {
//			List<MaterialResponse> MaterialResponseData = materialResponse.stream()
//					.filter(y -> y.getCategoryId() == x.getId()).collect(Collectors.toList());
//
//			x.getList().setList(MaterialResponseData);
//			return x;
//		}).collect(Collectors.toList());
//
//		response.setData(categoryResponse);
//		return new ResponseEntity<>(response, HttpStatus.OK);
//
//	}

}
