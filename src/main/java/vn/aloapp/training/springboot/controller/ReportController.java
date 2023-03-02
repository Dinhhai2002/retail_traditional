package vn.aloapp.training.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.BestSellerModel;
import vn.aloapp.training.springboot.entity.Report;
import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.service.ReportService;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController extends BaseController {
	@Autowired
	ReportService reportService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> statistical(
			@RequestParam(name = "week", required = true, defaultValue = "5") int week,
			@RequestParam(name = "from_date", required = true, defaultValue = "") String fromDate,
			@RequestParam(name = "to_date", required = true, defaultValue = "") String toDate,
			@RequestParam(name = "type", required = true, defaultValue = "1") int type,
			@RequestHeader(value = "authorization") String token )throws Exception {
		BaseResponse response = new BaseResponse();
		
		if (type <0 || type >5)
		{
			response.setStatus(HttpStatus.BAD_REQUEST);;
			response.setMessageError("kiểu nhập vào bắt buộc lớn hơn 0 và nhỏ hơn 6");
			return new ResponseEntity<BaseResponse>(response, HttpStatus.BAD_REQUEST);
		}
		
		this.accessToken(token);
		
		List<Report> statistical = reportService.spGAmountStatistical(week, this.formatDate(fromDate),
				this.formatDate(toDate), type);

		response.setData(statistical);

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(value = "/best-seller", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> bestSeller(
			@RequestParam(name = "week", required = true, defaultValue = "8") int week,
			@RequestParam(name = "from_date", required = true, defaultValue = "") String fromDate,
			@RequestParam(name = "to_date", required = true, defaultValue = "") String toDate,
			@RequestParam(name = "type", required = true, defaultValue = "1") int type,
			@RequestHeader(value = "authorization") String token ) throws Exception {
		BaseResponse response = new BaseResponse();
		
		User usertoken = this.accessToken(token);
		
		List<BestSellerModel> bestSeller = reportService.spGBestSeller(usertoken.getId(), week, this.formatDate(fromDate),
				this.formatDate(toDate), type);

		response.setData(bestSeller);

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
