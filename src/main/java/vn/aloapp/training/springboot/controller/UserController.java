package vn.aloapp.training.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.request.CRUDUserRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.UserResponse;
import vn.aloapp.training.springboot.service.SendEmail;
import vn.aloapp.training.springboot.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	SendEmail sendEmail;
	int otpvalue;
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse> findOne(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		response.setData(new UserResponse(userService.findOne(id)));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	
	
	@GetMapping("")
	public ResponseEntity<BaseResponse> spGUsers(
			@RequestParam(name = "key_search", required = false, defaultValue = "") String keySearch
			) throws Exception {
		BaseResponse response = new BaseResponse();
		response.setData(new UserResponse().mapToList(userService.spGUsers(keySearch )));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<BaseResponse> spUCreateUser(@Valid @RequestBody CRUDUserRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();
		wrapper.setPassword( BCrypt.hashpw(wrapper.getPassword(), BCrypt.gensalt(12)));
		response.setData(new UserResponse(userService.spUCreateUser(wrapper)));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/{id}/update")
	public ResponseEntity<BaseResponse> spUUpdateUser(@PathVariable("id") int id,
			@Valid @RequestBody CRUDUserRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();
		response.setData(new UserResponse(userService.spUUpdateUser(id, wrapper.getFirstName(),wrapper.getLastName(),wrapper.getFullName(),wrapper.getGender(),wrapper.getEmail(),wrapper.getWardId(),wrapper.getCityId(),
				wrapper.getDistrictId(),wrapper.getFbUid(),wrapper.getGgUid(),wrapper.getAppleUid(),wrapper.getPhone())));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/{id}/delete")
	public ResponseEntity<BaseResponse> deleteUser(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
	
		if (userService.deleteUser(id) >0) {
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
