package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.UserDao;
import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.request.CRUDUserRequest;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	

	@Override
	public User findOne(int id) throws Exception {
		return userDao.findOne(id);
	}

	@Override
	public User spUUpdateUser(int id, String firstName, String lastName, String fullName, int gender, String email,
			int wardId, int cityId, int districtId, String fbUid, String ggUid, String appleUid, String phone)
			throws Exception {
		return userDao.spUUpdateUser(id, firstName, lastName, fullName, gender, email, wardId, cityId, districtId, fbUid, ggUid, appleUid, phone);
	}

	@Override
	public List<User> spGUsers(String keyword) throws Exception {
		return userDao.spGUsers(keyword);
	}

	@Override
	public int deleteUser(int id) throws Exception {
		return userDao.deleteUser(id);
	}

	@Override
	public User spUCreateUser(String firstName, String lastName, int gender, String phone, String password) throws Exception {
		return userDao.spUCreateUser(firstName, lastName, gender, phone, password);
	}

	@Override
	public String spULogin(String phone, String password) throws Exception {
		
		return userDao.spULogin(phone, password);
	}

	@Override
	public String signOut(User user) throws Exception {
		
		return userDao.signOut(user);
	}

	@Override
	public void findUserByPhoneAndUpdateVerifyCode(String phone, int verifyCode) throws Exception{
		userDao.findUserByPhoneAndUpdateVerifyCode(phone, verifyCode);
		
	}

	@Override
	public User findUserByPhone(String phone) throws Exception {
		return userDao.findUserByPhone(phone);
	}

	@Override
	public void resetPasswordByUser(String password, int id) throws Exception {
		userDao.resetPasswordByUser(password, id);
		
	}
	

}
