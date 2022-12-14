package sms.student.action;

import java.util.ArrayList;
import java.util.Scanner;
import sms.student.controller.StudentController;
import sms.student.svc.GradeSearchService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Grade;

public class GradeSearchAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	GradeSearchService gradeSearchService = new GradeSearchService();

	@Override
	public void execute(Scanner sc) throws Exception {

		int searchMenuNum = consoleUtil.getSearchGradeMenuNum(sc);
		ArrayList<Grade> searchGradeList = null;

		if(searchMenuNum==1){
			String student_name = consoleUtil.getStudent_name("검색할 ", sc);
			searchGradeList = gradeSearchService.getSearchGradeListByStudent_name(student_name);
		}
		else if(searchMenuNum==2){
			int student_no = consoleUtil.getStudent_no("검색할 ", sc);
			searchGradeList = gradeSearchService.getSearchGradeListByStudent_no(student_no);
		}
		else if(searchMenuNum==3){
			int student_year = consoleUtil.getGrade("검색할 ", sc);
			searchGradeList = gradeSearchService.getSearchGradeListByStudent_year(student_year);
		}
		else if(searchMenuNum==4){
			consoleUtil.printSearchGradeCancel();
			return;
		}
		else {
			consoleUtil.printSearchMenuNumWrong();
			Action action = new GradeSearchAction();
			StudentController studentController = new StudentController();
			studentController.requestProcess(action, sc);
			return;
		}


		if(searchGradeList!=null) {
			consoleUtil.printGradeList(searchGradeList);
		}
		else {
			consoleUtil.printSearchGradeListNotFound();
		}
	}
	
}
