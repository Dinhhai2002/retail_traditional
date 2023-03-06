package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.request.CRUDUserRequest;

public interface UserDao {
	
	User spUCreateUser(String firstName, String lastName, int gender, String phone, String password) throws Exception;

	User findOne(int id) throws Exception;

	User spUUpdateUser(int id,String firstName,String lastName,String fullName,int gender,String email,int wardId,int cityId,int districtId,
			String fbUid,String ggUid,String appleUid,String phone) throws Exception;

	List<User> spGUsers(String keyword) throws Exception;

	int deleteUser(int id) throws Exception;

	String spULogin(String phone, String password) throws Exception;

	String signOut(User user) throws Exception;

	void findUserByPhoneAndUpdateVerifyCode(String phone, int verifyCode);

	User findUserByPhone(String phone) throws Exception;

	void resetPasswordByUser(String password, int id) throws Exception;
}
