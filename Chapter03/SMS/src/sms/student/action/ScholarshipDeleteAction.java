package sms.student.action;

import java.util.Scanner;
import sms.student.svc.ScholarshipDeleteService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Scholarship;

public class ScholarshipDeleteAction implements Action {
	
	ConsoleUtil consoleUtil = new ConsoleUtil();
	ScholarshipDeleteService scholarshipDeleteService = new ScholarshipDeleteService();

	@Override
	public void execute(Scanner sc) throws Exception {

		String sc_name = consoleUtil.getScholar_name("ªË¡¶«“ ", sc);
		Scholarship deletescholarship = scholarshipDeleteService.getDeleteScholarship(sc_name);

		if(deletescholarship == null) {
			consoleUtil.printScholarshipNotFound(sc_name);
			return;
		}

		boolean isDeleteSuccess = scholarshipDeleteService.deleteScore(sc_name);

		if(isDeleteSuccess) {
			consoleUtil.printDeleteSuccess(deletescholarship);
		}
		else{
			consoleUtil.printDeleteFail(deletescholarship);
		}	
		
	}
	
}
