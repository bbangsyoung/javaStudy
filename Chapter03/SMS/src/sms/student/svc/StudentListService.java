package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import sms.student.dao.StudentDAO;
import sms.student.vo.Student;

public class StudentListService {
	
	public ArrayList<Student> getStudentList() throws Exception{

		Connection con = getConnection();
		StudentDAO memberDAO = new StudentDAO(con);
		ArrayList<Student> studentList = memberDAO.selectStudentList();
		close(con);
		
		return studentList;
	}
	
}