package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.entity.WarehouseSession;
import vn.aloapp.training.springboot.request.CRUDWarehouseSessionRequest;

public interface WarehouseSessionService {

	WarehouseSession findOne(Long id) throws Exception;
	
	WarehouseSession importWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession exportWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession cancelWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession returnWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception;

	void spUExportWarehouseSessionFromOrder(long id) throws Exception;

	
}
