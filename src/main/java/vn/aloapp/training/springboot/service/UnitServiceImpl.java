package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.dao.UnitDao;
import vn.aloapp.training.springboot.entity.Unit;
import vn.aloapp.training.springboot.entity.UnitModel;


@Service("unitService")
@Transactional
public class UnitServiceImpl implements UnitService{
	
	@Autowired
	UnitDao unitDao;

	@Override
	public Unit spUCreateUnit(int userId, String name, String description) throws TechresHttpException{
		return unitDao.spUCreateUnit(userId, name, description);
	}


	@Override
	public Unit findByUserIdAndUnitId(int userId, int id) throws TechresHttpException {
		return unitDao.findByUserIdAndUnitId(userId, id);
	}

	@Override
	public Unit spUUpdateUnit(Unit unit) throws TechresHttpException {
		return unitDao.spUUpdateUnit(unit);
		
	}


	@Override
	public void spUChangeStatusUnit(int status, Integer id) throws TechresHttpException{
		unitDao.spUChangeStatusUnit(status, id);
		
	}


	@Override
	public List<UnitModel> spGUnitByMaterial(int id) throws TechresHttpException {
		return unitDao.spGUnitByMaterial(id);
	}


	@Override
	public void update(Unit unit) throws TechresHttpException {
		unitDao.update(unit);
		
	}


	@Override
	public List<Unit> spGFilterUnits(int userId, String keyword, int status) throws TechresHttpException {
		return unitDao.spGFilterUnits(userId, keyword, status);
	}


	@Override
	public Unit findByUserIdAndUnitIdAndStatus(int userId, int unitId, int status) throws TechresHttpException {
		return unitDao.findByUserIdAndUnitIdAndStatus(userId, unitId, status);
	}

}
