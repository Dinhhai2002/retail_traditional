package vn.aloapp.training.springboot.dao;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import vn.aloapp.training.common.enums.StoreProcedureStatusCodeEnum;
import vn.aloapp.training.common.exception.TechresHttpException;
import vn.aloapp.training.springboot.entity.Report;

@Repository("reportDao")
public class ReportDaoImpl extends AbstractDao<Long, Report> implements ReportDao {
	@SuppressWarnings("unchecked")
	@Override
	public List<Report> spGAmountStatistical(int week, String fromDate, String toDate,int type) throws Exception {
		StoredProcedureQuery query = this.getSession()
				.createStoredProcedureQuery("sp_g_amount_statistical", Report.class)

				.registerStoredProcedureParameter("_input", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("fromDateString", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("toDateString", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("_type", Integer.class, ParameterMode.IN)
				
				
				.registerStoredProcedureParameter("status_code", Integer.class, ParameterMode.OUT)
				.registerStoredProcedureParameter("message_error", String.class, ParameterMode.OUT);

		query.setParameter("_input", week);
		query.setParameter("fromDateString", fromDate);
		query.setParameter("toDateString", toDate);
		query.setParameter("_type", type);
		

		int statusCode = (int) query.getOutputParameterValue("status_code");
		String messageError = query.getOutputParameterValue("message_error").toString();

		switch (StoreProcedureStatusCodeEnum.valueOf(statusCode)) {
		case SUCCESS:
			return	 query.getResultList();
		case INPUT_INVALID:
			throw new TechresHttpException(HttpStatus.BAD_REQUEST, messageError);
		default:
			throw new Exception(messageError);
		}
	}
}
