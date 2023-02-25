package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.Report;

public interface ReportDao {
	public List<Report> spGAmountStatistical(int week,String fromDate,String toDate,int type) throws Exception;
}
