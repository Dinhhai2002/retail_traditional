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
import vn.aloapp.training.springboot.request.ChangePasswordRequest;
import vn.aloapp.training.springboot.request.ForgotPasswordRequest;
import vn.aloapp.training.springboot.request.ResetPasswordRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.UserResponse;
import vn.aloapp.training.springboot.service.SendEmail;
import vn.aloapp.training.springboot.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	SendEmail sendEmail;
	

	@PostMapping("/sign-in")
	public ResponseEntity<BaseResponse> spULogin(@Valid @RequestBody UserModel request) throws Exception {
		BaseResponse response = new BaseResponse();

		response.setData(userService.spULogin(request.getPhone(), request.getPassword()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/register")
	public ResponseEntity<BaseResponse> spUCreateUser(@Valid @RequestBody CRUDUserRequest wrapper) throws Exception {
		BaseResponse response = new BaseResponse();

		wrapper.setPassword(Base64.getEncoder().encodeToString(wrapper.getPassword().getBytes()));
		response.setData(new UserResponse(userService.spUCreateUser(wrapper.getFirstName(), wrapper.getLastName(),
				wrapper.getGender(), wrapper.getPhone(), wrapper.getPassword())));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/sign-out")
	public ResponseEntity<BaseResponse> signOut(@RequestHeader(value = "authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();

		User user = this.accessToken(token);
		response.setData(userService.signOut(user));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/forgot-password")
	public ResponseEntity<BaseResponse> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request)
			throws Exception {
		BaseResponse response = new BaseResponse();

		User user = userService.findUserByPhone(request.getPhone());

		if (user == null) {
			response.setData("Số điện thoại vừa nhập không tìm thấy.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}

		userService.findUserByPhoneAndUpdateVerifyCode(request.getPhone(), ((int) (Math.random() * 9000) + 1000));

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/{id}/reset-password")
	public ResponseEntity<BaseResponse> forgotPassword(@PathVariable("id") int id,
			@Valid @RequestBody ResetPasswordRequest request) throws Exception {
		BaseResponse response = new BaseResponse();

		User user = userService.findOne(id);

		if (user == null) {
			response.setData("Người dùng không tìm thấy hoặc không tồn tại.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}

		if (!request.getPassword().equals(request.getConfirmPassword())) {
			response.setData("Mật khẩu mới và xác nhận mật khẩu cần giống nhau.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}

		if (!user.getVerifyCode().equals(request.getOtp())) {
			response.setData("Mã OTP không chính xác vui lòng nhập lại.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}

		if (user.getPassword().equals(request.getPassword())) {
			response.setData("Nhập mật khẩu mới khác mật khẩu cũ.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}

		userService.resetPasswordByUser(request.getPassword(), id);
		response.setData("Đổi mật khẩu thành công.");

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping("/change-password")
	public ResponseEntity<BaseResponse> changePassword(@RequestHeader(value = "authorization") String token,
			@Valid @RequestBody ChangePasswordRequest request) throws Exception {
		BaseResponse response = new BaseResponse();

		User user = this.accessToken(token);

		if (!request.getPassword().equals(request.getConfirmPassword())) {
			response.setData("Mật khẩu mới và xác nhận mật khẩu cần giống nhau.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}

		if (user.getPassword().equals(request.getPassword())) {
			response.setData("Nhập mật khẩu mới khác mật khẩu cũ.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}

		if (!user.getPassword().equals(request.getOldPassword())) {
			response.setData("Nhập mật khẩu cũ không đúng.");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}

		userService.resetPasswordByUser(request.getPassword(), user.getId());
		response.setData("Đổi mật khẩu thành công vui lòng đăng nhập lại.");

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
