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
import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.request.CRUDCategoryRequest;
import vn.aloapp.training.springboot.request.CategoryRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.CategoryModel;
import vn.aloapp.training.springboot.response.CategoryResponse;
import vn.aloapp.training.springboot.service.CategoryService;
import vn.aloapp.training.springboot.service.MaterialService;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController extends BaseController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	MaterialService materialService;

	// get list Category
	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getList(@RequestHeader(value = "authorization") String token,
			@RequestParam(name = "keyword", defaultValue = "", required = false) String keyword,
			@RequestParam(name = "sort", defaultValue = "0", required = false) int sort,
			@RequestParam(name = "status", defaultValue = "-1", required = false) int status) throws Exception {

		BaseResponse response = new BaseResponse();
		User usertoken = this.accessToken(token);

		response.setData(new CategoryResponse().mapToList(categoryService.spGFilterCategories(usertoken.getId(), keyword, sort, status)));
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDCategoryRequest request,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		response.setData(new CategoryResponse(categoryService.spUCreateCategory(this.accessToken(token).getId(),
				request.getName().trim(), request.getSort(), request.getDescription())));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// update Category

	@PostMapping(value = "/{id}/update", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(@PathVariable("id") Integer id,
			@Valid @RequestBody CRUDCategoryRequest request, @RequestHeader(value = "authorization") String token)
			throws Exception {
		BaseResponse response = new BaseResponse();

		User usertoken = this.accessToken(token);
		Category category = categoryService.findByUserIdAndCategoryId(usertoken.getId(), id);

		if (category == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy danh mục có mã là: " + id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		category.setName(request.getName().trim());
		category.setUserId(usertoken.getId());
		category.setSort(request.getSort());
		category.setDescription(request.getDescription());
		response.setData(new CategoryResponse(categoryService.spUUpdateCategory(category)));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// get Category detail

	@GetMapping(value = "/{id}/detail", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getById(@PathVariable("id") Integer id,
			@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		User usertoken = this.accessToken(token);
		Category category = categoryService.findByUserIdAndCategoryId(usertoken.getId(), id);

		if (category == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy loại có mã là: " + id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		response.setData(new CategoryResponse(category));
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@PostMapping(value = "/{id}/change-status", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> changeStatus(@PathVariable("id") int id,
			@Valid @RequestBody CategoryRequest categoryRequest, @RequestHeader(value = "authorization") String token)
			throws Exception {
		BaseResponse response = new BaseResponse();

		User usertoken = this.accessToken(token);
		Category category = categoryService.findByUserIdAndCategoryId(usertoken.getId(), id);

		if (category == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy loại có mã là: " + id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		if (categoryRequest.getIsAccept() == 0 && category.getStatus()) {
			List<CategoryModel> categoryModels = categoryService.spGCategoriesV2(usertoken.getId(), id);
			if (categoryModels.stream().anyMatch(x -> !x.getLists().isEmpty())) {

				response.setStatus(HttpStatus.MULTIPLE_CHOICES);
				response.setMessageError(
						" Có nguyên liệu đang nằm trong danh mục này , bạn có muốn tắt danh mục này không ");
			}
			response.setStatus(HttpStatus.MULTIPLE_CHOICES);
			response.setMessageError("Bạn có chắc muốn đổi trạng thái? nếu có thay đổi giá trị is_accept là 1.");

		} else {

			category.setStatus(!category.getStatus());
			categoryService.update(category);

			if (!category.getStatus())
				materialService.spUDeleteCategoryIdByMaterial(id);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	// get list Category
//	@GetMapping(value = "/get-tree", produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> getListTreeV2(@RequestHeader(value = "authorization") String token)
//			throws Exception {
//		BaseResponse response = new BaseResponse();
//		User usertoken = this.accessToken(token);
//		response.setData(new CategoryResponse().mapToList(categoryService.findByCategoryByUserId(usertoken.getId())));
//		return new ResponseEntity<>(response, HttpStatus.OK);
//
//	}

}
