/**
 * 
 */
package vn.aloapp.training.springboot.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import vn.aloapp.training.springboot.response.BaseResponse;

/**
 * @author kelvin
 *
 */

@RestController
public class BaseController {
	
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
	
	public String formatDate(String date)
	{
	    DateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
	    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	      Date date1 = inputFormat.parse(date);
	      String outputDateStr = outputFormat.format(date1);
	      return outputDateStr;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		return null;
	}
}
