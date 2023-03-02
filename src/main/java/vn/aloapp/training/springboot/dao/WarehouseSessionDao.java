package vn.aloapp.training.springboot.dao;

import vn.aloapp.training.springboot.entity.WarehouseSession;
import vn.aloapp.training.springboot.request.CRUDWarehouseSessionRequest;

public interface WarehouseSessionDao {

	WarehouseSession findOne(Long id) throws Exception;
	
	WarehouseSession importWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession exportWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession cancelWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession returnWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception;

	void spUExportWarehouseSessionFromOrder(long id) throws Exception;
	
	

}
