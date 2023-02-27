package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.entity.WarehouseSession;
import vn.aloapp.training.springboot.request.CRUDWarehouseSessionRequest;

public interface WarehouseSessionDao {

	WarehouseSession findOne(Long id) throws Exception;
	
	WarehouseSession importWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession exportWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession cancelWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession returnWarehouseSession(CRUDWarehouseSessionRequest wrapper, String warehouseSessionDetails) throws Exception;

	void spUExportWarehouseSessionFromOrder(long id) throws Exception;
	
	

}
