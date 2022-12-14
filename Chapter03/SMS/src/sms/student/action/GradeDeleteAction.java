package sms.student.action;

import java.util.Scanner;
import sms.student.svc.GradeDeleteService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Grade;

public class GradeDeleteAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	GradeDeleteService gradeDeleteService = new GradeDeleteService();

	@Override
	public void execute(Scanner sc) throws Exception {

		int student_no = consoleUtil.getStudent_no("ªË¡¶«“ ", sc);
		Grade deleteScore = gradeDeleteService.getDeleteScore(student_no);

		if(deleteScore == null) {
			consoleUtil.printGradeNotFound(student_no);
			return;
		}

		boolean isDeleteSuccess = gradeDeleteService.deleteGrade(student_no);

		if(isDeleteSuccess) {
			consoleUtil.printDeleteSuccess(deleteScore);
		}
		else{
			consoleUtil.printDeleteFail(deleteScore);
		}
	}
	
}
