/**
 * 
 */
package vn.aloapp.training.springboot.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.service.UserService;

/**
 * @author kelvin
 *
 */

@RestController
public class BaseController {
	
	@Autowired
	UserService userService;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public final ResponseEntity<BaseResponse> handleUserNotFoundException(MethodArgumentNotValidException ex, WebRequest request) {

		BaseResponse response = new BaseResponse();
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setMessageError("Dữ liệu không hợp lệ");
		
		List<String> errors = ex.getBindingResult().getFieldErrors()
				.stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
		
		response.setData(errors);
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<BaseResponse> handleMissingParams(MissingServletRequestParameterException ex) {
		// Actual exception handling
		BaseResponse response = new BaseResponse();
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setMessageError(String.format("%s is required!", ex.getParameterName()));
		response.setData(null);

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	

	public String formatDate(String inputDate) throws ParseException
	{
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date inputDate1 = inputDateFormat.parse(inputDate);

        SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String outputDateStr = outputDateFormat.format(inputDate1);

        return outputDateStr;
	}
	
	@SuppressWarnings("unused")
	public User accessToken(String encodeString) throws Exception {

		byte[] decodedBytes = Base64.getMimeDecoder().decode(encodeString);
		
		

		String decodedMime = new String(decodedBytes);

		ObjectMapper mapper = new ObjectMapper();
		try {
			User map = mapper.readValue(decodedMime, User.class);			
			
			User user = userService.findOne(map.getId());
			
			
			if (user.getIsLogin() == 0 && user.getAccessToken()== "")
				throw new Exception("Tài khoản chưa đăng nhập");
			if (user != null)
				return user;
			else
				throw new Exception("Thất bại");
		} catch (Exception e) {
			throw new Exception("Thất bại");
		}

	}

}
