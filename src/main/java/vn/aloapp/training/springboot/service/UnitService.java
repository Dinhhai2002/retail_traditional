package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Unit;
import vn.aloapp.training.springboot.entity.UnitModel;


public interface UnitService {

	Unit spUCreateUnit(int userId, String name, String description) throws Exception;

	Unit findOne(Integer id) throws Exception;

	Unit spUUpdateUnit(Unit unit) throws Exception;

	void spUChangeStatusUnit(int status, Integer id) throws Exception;

	List<Unit> spListUnit(int status) throws TechresHttpException;

	List<UnitModel> spGUnitByMaterial(int id) throws Exception;

	void update(Unit unit) throws Exception;

}
