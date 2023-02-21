package vn.aloapp.training.springboot.dao;

import org.springframework.stereotype.Repository;

import vn.aloapp.training.springboot.entity.WarehouseSessionDetail;
@Repository("WarehouseSessionsDetailDao")
@SuppressWarnings("unchecked")
public class WarehouseSessionsDetailDaoImpl extends AbstractDao<Integer, WarehouseSessionDetail> implements WarehouseSessionsDetailDao {

}
