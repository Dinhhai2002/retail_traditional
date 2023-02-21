package vn.aloapp.training.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.WarehouseSessionDao;
import vn.aloapp.training.springboot.entity.WarehouseSession;

@Service("warehouseSessionService")
@Transactional
public class WarehouseSessionServiceImpl implements WarehouseSessionService{
	
	@Autowired
	WarehouseSessionDao dao;

	@Override
	public WarehouseSession findOne(Long id) throws Exception {
		return dao.findOne(id);
	}

}
