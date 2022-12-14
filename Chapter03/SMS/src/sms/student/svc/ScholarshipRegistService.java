package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.ScholarshipDAO;
import sms.student.vo.Scholarship;

public class ScholarshipRegistService {

	public boolean searchScholarship(String sc_name) throws Exception{
		
		boolean isRegisted = false;
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		Scholarship searchScholarship = scholarshipDAO.selectScholarship(sc_name);

		if(searchScholarship != null) {
			isRegisted = true;
		}
			
		close(con);	
		return isRegisted;
		
	}

	public boolean registScholarship(Scholarship newScholarship) throws Exception{

		boolean isRegistSuccess = false;
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		int insertCount = scholarshipDAO.insertScholarship(newScholarship);

		if(insertCount > 0) {
			isRegistSuccess = true;
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);		
		return isRegistSuccess;
		
	}
	
}
