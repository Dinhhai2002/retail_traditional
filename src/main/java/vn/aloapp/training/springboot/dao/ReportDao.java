package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.BestSellerModel;
import vn.aloapp.training.springboot.entity.Report;

public interface ReportDao {
	public List<Report> spGAmountStatistical(int userId, int week,String fromDate,String toDate,int type) throws Exception;

	public List<BestSellerModel> spGBestSeller(int userId, int week, String formatDate, String toDate, int type) throws Exception;
}
