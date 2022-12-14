package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import sms.student.dao.GradeDAO;
import sms.student.dao.ScholarshipDAO;
import sms.student.vo.Scholarship;
import sms.student.vo.ScholarshipStudent;
import sms.student.vo.Grade;

public class ScholarshipStudentSearchService {

	public Scholarship getSearchScholarship(String scholar_name) throws Exception{
		
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		Scholarship searchScholarship = scholarshipDAO.selectScholarship(scholar_name);
		close(con);
		return searchScholarship;
		
	}

	public ArrayList<Grade> getScoreListAddPercent() throws Exception{
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		ArrayList<Grade> gradeList = gradeDAO.selectGradeList();
		ArrayList<Grade> gradeListAddPercent = gradeDAO.selectGradeListAddPercent(gradeList.size());
		close(con);
		return gradeListAddPercent;
		
	}

	public ArrayList<ScholarshipStudent> getScholarshipStudentSearchList(
			Scholarship searchScholarship, ArrayList<Grade> gradeListAddPercent) throws Exception{

		ArrayList<ScholarshipStudent> searchScholarshipStudentList =
				new ArrayList<ScholarshipStudent>();
		ScholarshipStudent scholarshipStudent = null;
		
		for(int i=0 ; i<gradeListAddPercent.size()-1 ; i++) {
			if(gradeListAddPercent.get(i).getAvg() == gradeListAddPercent.get(i+1).getAvg()) {
				gradeListAddPercent.get(i+1).setPercent(gradeListAddPercent.get(i).getPercent());
			}
		}
		
		for(int i=0 ; i < gradeListAddPercent.size() ; i++) {
			
			if(gradeListAddPercent.get(i).getPercent() <= searchScholarship.getScholar_percent()) {
				scholarshipStudent = new ScholarshipStudent(
						gradeListAddPercent.get(i).getStudent_no(),
						gradeListAddPercent.get(i).getStudent_name(),
						gradeListAddPercent.get(i).getAvg(),
						searchScholarship.getScholar_name(),
						gradeListAddPercent.get(i).getPercent(),
						searchScholarship.getScholar_money());
				
				searchScholarshipStudentList.add(scholarshipStudent);
			}
		}
		
		return searchScholarshipStudentList;
		
	}
	
}
