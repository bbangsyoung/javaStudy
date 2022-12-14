package sms.student.action;

import java.util.Scanner;
import sms.student.svc.GradeModifyService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Grade;

public class GradeModifyAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	GradeModifyService gradeModifyService =	new GradeModifyService();

	@Override
	public void execute(Scanner sc) throws Exception {		
		
		int student_no = consoleUtil.getStudent_no("¼öÁ¤ÇÒ ", sc);
		Grade modifyGrade = gradeModifyService.getModifyGrade(student_no);
		
		if(modifyGrade == null) {
			consoleUtil.printGradeNotFound(student_no);
			return;
		}
		
		Grade changeGrade = consoleUtil.getChangeGrade(modifyGrade, sc);
		boolean isModifySuccess = gradeModifyService.modifyGrade(changeGrade);
		
		if(isModifySuccess) {
			consoleUtil.printModifySuccess(changeGrade);
		}
		else {
			consoleUtil.printModifyFail(changeGrade);
		}
	}
	
}
