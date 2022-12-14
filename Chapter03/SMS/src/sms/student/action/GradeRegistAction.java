package sms.student.action;

import java.util.Scanner;
import sms.student.svc.GradeRegistService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Grade;
import sms.student.vo.Student;

public class GradeRegistAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	GradeRegistService gradeRegistService = new GradeRegistService();

	@Override
	public void execute(Scanner sc) throws Exception {
		
		int student_no = consoleUtil.getStudent_no("ภิทยวา ", sc);
		Student rightStudent = gradeRegistService.getRightStudent(student_no);
		
		if(rightStudent == null) {
			consoleUtil.printStudentNotFound(student_no);
			return;
		}

		boolean isRegisted = gradeRegistService.searchGrade(student_no);
		
		if(isRegisted) {
			consoleUtil.printRegistedGrade(student_no);
			return;
		}

		Grade newGrade = consoleUtil.getNewGrade(student_no, sc);
		boolean isRegistSuccess = gradeRegistService.registGrade(newGrade);

		if(isRegistSuccess) {
			consoleUtil.printRegistSuccess(newGrade);
		}
		else {
			consoleUtil.printRegistFail(newGrade);
		}
	}
}
