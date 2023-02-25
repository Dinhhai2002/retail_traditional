package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.WarehouseSession;
import vn.aloapp.training.springboot.request.CRUDWarehouseSessionRequest;

public interface WarehouseSessionService {

	WarehouseSession findOne(Long id) throws Exception;
	
	WarehouseSession importWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception;
	
	WarehouseSession exportWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception;
	
	WarehouseSession cancelWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception;
	
	WarehouseSession returnWarehouseSession(CRUDWarehouseSessionRequest wrapper) throws Exception;

	
}
