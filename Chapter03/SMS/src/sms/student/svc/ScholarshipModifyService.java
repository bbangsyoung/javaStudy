package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.ScholarshipDAO;
import sms.student.vo.Scholarship;

public class ScholarshipModifyService {

	public Scholarship getModifyScholarship(String sc_name) throws Exception{
		
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);	
		Scholarship modifyScholarshop = scholarshipDAO.selectScholarship(sc_name);		
		close(con);
		
		return modifyScholarshop;
		
	}

	public boolean modifyScholarship(Scholarship changeScholarship) throws Exception{
		
		boolean isModifySuccess = false;	
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		int updateCount = scholarshipDAO.updateScholarship(changeScholarship);
		
		if(updateCount > 0){
			isModifySuccess = true;
			commit(con);
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isModifySuccess;
		
	}
	
}
