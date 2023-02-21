package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.entity.WarehouseSession;

public interface WarehouseSessionService {

	WarehouseSession findOne(Long id) throws Exception;

}
