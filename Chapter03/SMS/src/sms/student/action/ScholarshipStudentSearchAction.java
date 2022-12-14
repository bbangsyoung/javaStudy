package sms.student.action;

import java.util.ArrayList;
import java.util.Scanner;

import sms.student.svc.ScholarshipStudentSearchService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Scholarship;
import sms.student.vo.ScholarshipStudent;
import sms.student.vo.Grade;

public class ScholarshipStudentSearchAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	ScholarshipStudentSearchService scholarshipStudentSearchService = new ScholarshipStudentSearchService();

	
	@Override
	public void execute(Scanner sc) throws Exception {
				
		String sc_name = consoleUtil.getScholar_name("°Ë»öÇÒ ", sc);
		
		Scholarship searchScholarship = scholarshipStudentSearchService.getSearchScholarship(sc_name);
		
		if(searchScholarship == null) {
			consoleUtil.printScholarshipNotFound(sc_name);
			return;
		}
		
		
		ArrayList<Grade> scoreListAddPercent = scholarshipStudentSearchService.getScoreListAddPercent();
				
		ArrayList<ScholarshipStudent> scholarshipStudentSearchList =
				scholarshipStudentSearchService.getScholarshipStudentSearchList(searchScholarship, scoreListAddPercent);
				
		if(scholarshipStudentSearchList.size() != 0) {
			consoleUtil.printScholarshipStudentList(scholarshipStudentSearchList);
		}
		else {
			consoleUtil.printScholarshipStudentListNotFound();
		}
	}
}
