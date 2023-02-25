package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.Report;

public interface ReportService {
	public List<Report> spGAmountStatistical(int week,String fromDate,String toDate,int type) throws Exception;
}
