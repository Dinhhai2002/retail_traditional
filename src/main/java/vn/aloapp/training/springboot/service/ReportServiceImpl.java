package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.ReportDao;
import vn.aloapp.training.springboot.entity.Report;

@Service
@Transactional(rollbackFor = Error.class)
public class ReportServiceImpl implements ReportService {
	@Autowired
	ReportDao reportDao;

	@Override
	public List<Report> spGAmountStatistical(int week, String fromDate, String toDate, int type) throws Exception {
		return reportDao.spGAmountStatistical(week, fromDate, toDate, type);
	}
	
	

}
