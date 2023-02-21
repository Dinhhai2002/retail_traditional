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
	public Unit findOne(Integer id) throws Exception {
		return unitDao.findOne(id);
	}

	@Override
	public Unit spUUpdateUnit(Unit unit) throws Exception {
		return unitDao.spUUpdateUnit(unit);
		
	}


	@Override
	public void spUChangeStatusUnit(int status, Integer id) throws Exception{
		unitDao.spUChangeStatusUnit(status, id);
		
	}


	@Override
	public List<Unit> spListUnit(int status) throws TechresHttpException {
		return unitDao.spListUnit(status);
	}


	@Override
	public List<UnitModel> spGUnitByMaterial(int id) throws Exception {
		// TODO Auto-generated method stub
		return unitDao.spGUnitByMaterial(id);
	}


	@Override
	public void update(Unit unit) throws Exception {
		unitDao.update(unit);
		
	}

}
