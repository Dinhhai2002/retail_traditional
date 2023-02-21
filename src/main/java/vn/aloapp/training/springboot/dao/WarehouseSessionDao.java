package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.entity.WarehouseSession;

public interface WarehouseSessionDao {

	WarehouseSession findOne(Long id) throws Exception;

}
