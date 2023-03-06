package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Unit;
import vn.aloapp.training.springboot.entity.UnitModel;


public interface UnitDao {

	Unit spUCreateUnit(int userId, String name, String description)throws TechresHttpException;

	Unit findByUserIdAndUnitId(int userId, int id) throws TechresHttpException;

	Unit spUUpdateUnit(Unit unit) throws TechresHttpException;

	void spUChangeStatusUnit(int status, Integer id) throws TechresHttpException;

	List<UnitModel> spGUnitByMaterial(int id) throws TechresHttpException;

	void update(Unit unit) throws TechresHttpException;

	List<Unit> spGFilterUnits(int userId, String keyword, int status) throws TechresHttpException;

	Unit findByUserIdAndUnitIdAndStatus(int userId, int unitId, int status) throws TechresHttpException;

}
