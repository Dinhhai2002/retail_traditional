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
	public WarehouseSession importWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception {
		return warehouseSessionDao.importWarehouseSession(wrapper, warehouseSessionDetails);
	}

	@Override
	public WarehouseSession exportWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception {
		return warehouseSessionDao.exportWarehouseSession(wrapper, warehouseSessionDetails);
	}

	@Override
	public WarehouseSession cancelWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception {
		return warehouseSessionDao.cancelWarehouseSession(wrapper, warehouseSessionDetails);
	}

	@Override
	public WarehouseSession returnWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception {
		return warehouseSessionDao.returnWarehouseSession(wrapper, warehouseSessionDetails);
	}

	@Override
	public void spUExportWarehouseSessionFromOrder(long id) throws Exception {
		warehouseSessionDao.spUExportWarehouseSessionFromOrder(id);
		
	}

	

}
