package sms.student.action;

import java.util.Scanner;
import sms.student.svc.StudentModifyService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Student;

public class StudentModifyAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	StudentModifyService studentModifyService =	new StudentModifyService();

	@Override
	public void execute(Scanner sc) throws Exception {
		
		int stu_no = consoleUtil.getStudent_no("¼öÁ¤ÇÒ ", sc);
		Student modifyStudent = studentModifyService.getModifyStudent(stu_no);
		
		if(modifyStudent == null) {
			consoleUtil.printStudentNotFound(stu_no);
			return;
		}
		
		Student changeStudent = consoleUtil.getChangeStudent(modifyStudent, sc);
		String unfitForm = studentModifyService.compareBirthRegistForm(changeStudent);
		
		if(unfitForm != null) {
			consoleUtil.printUnfitForm(unfitForm);
			return;
		}
		
		boolean isModifySuccess = studentModifyService.modifyStudent(changeStudent);
		
		if(isModifySuccess) {
			consoleUtil.printModifySuccess(stu_no);
		}
		else {
			consoleUtil.printModifyFail(stu_no);
		}
	}
	
}
