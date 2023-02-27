package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.User;
import vn.aloapp.training.springboot.request.CRUDUserRequest;
@Repository("UserDao")
@SuppressWarnings("unchecked")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public User spUCreateUser(CRUDUserRequest wrapper) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_create_user", User.class)
				.registerStoredProcedureParameter("firstName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("lastName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_gender", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_password", String.class, ParameterMode.IN)
				

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("firstName", wrapper.getFirstName());
		query.setParameter("lastName",  wrapper.getLastName());
		query.setParameter("_gender", wrapper.getGender());
		query.setParameter("_phone", wrapper.getPhone());
		query.setParameter("_password", wrapper.getPassword());

		
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (User) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public User findOne(int id) throws Exception {
		return this.getSession().find(User.class, id);
	}

	@Override
	public User spUUpdateUser(int id, String firstName, String lastName, String fullName, int gender, String email,
			int wardId, int cityId, int districtId, String fbUid, String ggUid, String appleUid, String phone)
			throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_update_user", User.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("firstName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("lastName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("fullName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_gender", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_email", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("wardId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("cityId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("districtId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("fbUid", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("ggUid", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("appleUid", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_phone", String.class, ParameterMode.IN)
				
				

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("_id", id);
		query.setParameter("firstName", firstName);
		query.setParameter("lastName", lastName);
		query.setParameter("fullName", fullName);
		query.setParameter("_gender", gender);
		query.setParameter("_email", email);
		query.setParameter("wardId", wardId);
		query.setParameter("cityId", cityId);
		query.setParameter("districtId", districtId);
		query.setParameter("fbUid", fbUid);
		query.setParameter("ggUid", ggUid);
		query.setParameter("appleUid", appleUid);
		query.setParameter("_phone", phone);
		

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return (User) query.getResultList().stream().findFirst().orElse(null);
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public List<User> spGUsers(String keyword) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_g_users", User.class)
				
				.registerStoredProcedureParameter("keySearch", String.class, ParameterMode.IN)

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("keySearch", keyword);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return query.getResultList();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}

	@Override
	public int deleteUser(int id) throws Exception {
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_delete_user", User.class)
				.registerStoredProcedureParameter("_id", Integer.class, ParameterMode.IN)
				

				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);
		
		query.setParameter("_id", id);
		
		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return query.executeUpdate();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
		
	}

	@Override
	public String spULogin(String phone, String password) throws Exception {
		
		StoredProcedureQuery query = this.getSession().createStoredProcedureQuery("sp_u_login")
				
				.registerStoredProcedureParameter("_phone", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_password", String.class, ParameterMode.IN)

				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("accessToken", String.class, ParameterMode.OUT);
		
		query.setParameter("_phone", phone);
		query.setParameter("_password", password);

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();
		String accessToken = query.getOutputParameterValue("accessToken").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return accessToken;
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}
}
