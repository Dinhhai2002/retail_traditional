package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.ReportDao;
import vn.aloapp.training.springboot.entity.BestSellerModel;
import vn.aloapp.training.springboot.entity.Inventory;
import vn.aloapp.training.springboot.entity.Report;

@Service
@Transactional(rollbackFor = Error.class)
public class ReportServiceImpl implements ReportService {
	@Autowired
	ReportDao reportDao;

	@Override
	public List<Report> spGAmountStatistical(int userId, int week, String fromDate, String toDate, int type) throws Exception {
		return reportDao.spGAmountStatistical(userId, week, fromDate, toDate, type);
	}

	@Override
	public List<BestSellerModel> spGReportBestSeller(int userId, int week, String formatDate, String toDate, int type)
			throws Exception {
		return reportDao.spGReportBestSeller(userId, week, formatDate, toDate, type);
	}

	@Override
	public List<Inventory> spGReportInventory(int userId) throws Exception {
		return reportDao.spGReportInventory(userId);
	}

	
	

}
