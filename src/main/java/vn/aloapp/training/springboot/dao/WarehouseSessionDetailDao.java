package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.WarehouseSessionDetail;

public interface WarehouseSessionDetailDao {

	List<WarehouseSessionDetail> spGWarehouseSessionDetailByWarehouseSessionId(long id) throws Exception;

}
