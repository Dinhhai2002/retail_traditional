package vn.aloapp.training.springboot.service;

import vn.aloapp.training.springboot.entity.WarehouseSession;
import vn.aloapp.training.springboot.request.CRUDWarehouseSessionRequest;

public interface WarehouseSessionService {

	WarehouseSession findOne(Long id) throws Exception;
	
	
	WarehouseSession exportWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession cancelWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception;
	
	WarehouseSession returnWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception;

	void spUExportWarehouseSessionFromOrder(long userId) throws Exception;

	WarehouseSession importWarehouseSession(int userId, double discountPercent, double vat, double discountAmount,
			String description, String warehouseSessionDetails) throws Exception;

	
}
