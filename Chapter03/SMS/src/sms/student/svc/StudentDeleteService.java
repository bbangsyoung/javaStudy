package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.StudentDAO;
import sms.student.vo.Student;

public class StudentDeleteService {

	public Student getDeleteStudent(int stu_no) throws Exception{
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		Student deleteStudent = studentDAO.selectStudent(stu_no);
		close(con);
		return deleteStudent;
		
	}
		
	public boolean deleteStudent(int stu_no) throws Exception{
		
		boolean isDeleteSuccess = false;
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		int deleteCount = studentDAO.deleteStudent(stu_no);
		
		if(deleteCount > 0) {
			isDeleteSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		
		close(con);
		return isDeleteSuccess;
		
	}
	
}
