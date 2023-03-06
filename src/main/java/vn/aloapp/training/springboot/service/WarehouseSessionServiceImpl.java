package vn.aloapp.training.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.WarehouseSessionDao;
import vn.aloapp.training.springboot.entity.WarehouseSession;
import vn.aloapp.training.springboot.request.CRUDWarehouseSessionRequest;

@Service("warehouseSessionService")
@Transactional
public class WarehouseSessionServiceImpl implements WarehouseSessionService{
	
	@Autowired
	WarehouseSessionDao warehouseSessionDao;

	@Override
	public WarehouseSession findOne(Long id) throws Exception {
		return warehouseSessionDao.findOne(id);
	}


	@Override
	public WarehouseSession exportWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception {
		return warehouseSessionDao.exportWarehouseSession(userId, discountPercent, vat, discountAmount, description, warehouseSessionDetails);
	}

	@Override
	public WarehouseSession cancelWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception {
		return warehouseSessionDao.cancelWarehouseSession(userId, discountPercent, vat, discountAmount, description, warehouseSessionDetails);
	}

	@Override
	public WarehouseSession returnWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception {
		return warehouseSessionDao.returnWarehouseSession(userId, discountPercent, vat, discountAmount, description, warehouseSessionDetails);
	}

	@Override
	public void spUExportWarehouseSessionFromOrder(long id) throws Exception {
		warehouseSessionDao.spUExportWarehouseSessionFromOrder(id);
		
	}


	@Override
	public WarehouseSession importWarehouseSession(int userId, double discountPercent, double vat,
			double discountAmount, String description, String warehouseSessionDetails) throws Exception {
		return warehouseSessionDao.importWarehouseSession(userId, discountPercent, vat, discountAmount, description, warehouseSessionDetails);
	}

	

}
