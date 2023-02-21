package vn.aloapp.training.springboot.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.springboot.entity.WarehouseSession;

@Repository("warehouseSessionDao")
public class WarehouseSessionDaoImpl extends AbstractDao<Long, WarehouseSession> implements WarehouseSessionDao{

	@Override
	public WarehouseSession findOne(Long id) throws Exception {
		return (WarehouseSession) this.getSession().createCriteria(WarehouseSession.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

}
