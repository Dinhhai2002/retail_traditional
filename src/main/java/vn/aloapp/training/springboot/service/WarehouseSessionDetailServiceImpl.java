package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.WarehouseSessionDetailDao;
import vn.aloapp.training.springboot.entity.WarehouseSessionDetail;

@Service("warehouseSessionDetailService")
@Transactional(rollbackFor = Error.class)
public class WarehouseSessionDetailServiceImpl implements WarehouseSessionDetailService{
	
	@Autowired
	WarehouseSessionDetailDao dao;

	@Override
	public List<WarehouseSessionDetail> spGWarehouseSessionDetailByWarehouseSessionId(long id) throws Exception {
		return dao.spGWarehouseSessionDetailByWarehouseSessionId(id);
	}

}
