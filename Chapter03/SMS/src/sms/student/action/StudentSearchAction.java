package sms.student.action;

import java.util.ArrayList;
import java.util.Scanner;
import sms.student.controller.StudentController;
import sms.student.svc.StudentSearchService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Student;

public class StudentSearchAction implements Action {
	
	ConsoleUtil consoleUtil = new ConsoleUtil();
	StudentSearchService studentSearchService =	new StudentSearchService();

	@Override
	public void execute(Scanner sc) throws Exception {

		int searchMenuNum = consoleUtil.getSearchMenuNum(sc);
		
		ArrayList<Student> searchStudentList = null;
		
		if(searchMenuNum==1){
			String stu_name = consoleUtil.getStudent_name("검색할 ", sc);
			searchStudentList = studentSearchService.getSearchStudentListByStudent_name(stu_name);
		}
		else if(searchMenuNum==2){
			int stu_no = consoleUtil.getStudent_no("검색할 ", sc);
			searchStudentList = studentSearchService.getSearchStudentListByStudent_no(stu_no);
		}
		else if(searchMenuNum==3){
			int student_year = consoleUtil.getGrade("검색할 ", sc);
			searchStudentList = studentSearchService.getSearchStudentListByStudent_year(student_year);
		}
		else if(searchMenuNum==4){
			consoleUtil.printSearchStudentCancel();
			return;
		}
		else {
			consoleUtil.printSearchMenuNumWrong();
			Action action = new StudentSearchAction();
			StudentController studentController = new StudentController();
			studentController.requestProcess(action, sc);
			return;
		}
		
		
		if(searchStudentList!=null) {
			consoleUtil.printStudentList(searchStudentList);
		}
		else {
			consoleUtil.printSearchStudentListNotFound();
		}
	}
}
