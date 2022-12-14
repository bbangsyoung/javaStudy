package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.GradeDAO;
import sms.student.dao.StudentDAO;
import sms.student.vo.Grade;
import sms.student.vo.Student;

public class GradeRegistService {
		
	public Student getRightStudent(int student_no) throws Exception{
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);		
		Student rightStudent = studentDAO.selectStudent(student_no);		
		close(con);
		return rightStudent;
		
	}
	
	public boolean searchGrade(int student_no) throws Exception{
		
		boolean isRegisted = false;
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		Grade searchGrade = gradeDAO.selectGrade(student_no);
		
		if(searchGrade != null) {
			isRegisted = true;
		}
		
		close(con);
		return isRegisted;
		
	}
	
	public boolean registGrade(Grade newGrade) throws Exception{
		
		boolean isRegistGradeSuccess = false;
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		int insertCount = gradeDAO.insertGrade(newGrade);
		
		if(insertCount > 0) {
			isRegistGradeSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isRegistGradeSuccess;
		
	}

}
