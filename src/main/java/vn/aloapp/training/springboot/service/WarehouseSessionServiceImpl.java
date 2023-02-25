package vn.aloapp.training.springboot.service;

import java.util.List;

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
	public WarehouseSession importWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception {
		return warehouseSessionDao.importWarehouseSession(wrapper);
	}

	@Override
	public WarehouseSession exportWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception {
		return warehouseSessionDao.exportWarehouseSession(wrapper);
	}

	@Override
	public WarehouseSession cancelWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception {
		return warehouseSessionDao.cancelWarehouseSession(wrapper);
	}

	@Override
	public WarehouseSession returnWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception {
		return warehouseSessionDao.returnWarehouseSession(wrapper);
	}

	

}
