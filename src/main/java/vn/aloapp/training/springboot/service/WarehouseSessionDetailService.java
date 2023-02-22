package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.WarehouseSessionDetail;

public interface WarehouseSessionDetailService {

	List<WarehouseSessionDetail> spGWarehouseSessionDetailByWarehouseSessionId(long id) throws Exception;

}
