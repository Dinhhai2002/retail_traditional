package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.request.CRUDUserRequest;

public interface UserService {
	User spUCreateUser(CRUDUserRequest wrapper) throws Exception;

	User findOne(int id) throws Exception;

	User spUUpdateUser(int id,String firstName,String lastName,String fullName,int gender,String email,int wardId,int cityId,int districtId,
			String fbUid,String ggUid,String appleUid,String phone) throws Exception;

	List<User> spGUsers(String keyword) throws Exception;

	int deleteUser(int id) throws Exception;

}
