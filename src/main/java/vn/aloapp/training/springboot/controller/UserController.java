package vn.aloapp.training.springboot.controller;

import java.util.Base64;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.entity.UserModel;
import vn.aloapp.training.springboot.request.CRUDUserRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.UserResponse;
import vn.aloapp.training.springboot.service.SendEmail;
import vn.aloapp.training.springboot.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends BaseController{
	@Autowired
	UserService userService;
	@Autowired
	SendEmail sendEmail;
	int otpvalue;
	
	
	@PostMapping("/sign-in")
	public ResponseEntity<BaseResponse> spULogin(@Valid @RequestBody UserModel request) throws Exception {
		BaseResponse response = new BaseResponse();
		
		request.setPassword(Base64.getEncoder().encodeToString(request.getPassword().getBytes()));
		response.setData(userService.spULogin(request.getPhone(), request.getPassword()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}


	@PostMapping("/create")
	public ResponseEntity<BaseResponse> spUCreateUser(@Valid @RequestBody CRUDUserRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();		
	
		wrapper.setPassword(Base64.getEncoder().encodeToString(wrapper.getPassword().getBytes()));
		response.setData(new UserResponse(userService.spUCreateUser(wrapper.getFirstName(), 
																	wrapper.getLastName(), 
																	wrapper.getGender(),
																	wrapper.getPhone(),
																	wrapper.getPassword()
																	)));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	
	@PostMapping("/sign-out")
	public ResponseEntity<BaseResponse> signOut(@RequestHeader(value = "authorization")  String token) throws Exception {
		BaseResponse response = new BaseResponse();
		
		User user = this.accessToken(token);
		response.setData(userService.signOut(user));
		
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<BaseResponse> findOne(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		response.setData(new UserResponse(userService.findOne(id)));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<BaseResponse> spGUsers(
			@RequestParam(name = "key_search", required = false, defaultValue = "") String keySearch) throws Exception {
		BaseResponse response = new BaseResponse();
		response.setData(new UserResponse().mapToList(userService.spGUsers(keySearch)));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);

	}


	@PostMapping("/{id}/delete")
	public ResponseEntity<BaseResponse> deleteUser(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();

		if (userService.deleteUser(id) > 0) {
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
	}

}
