package sms.student.action;

import java.util.Scanner;
import sms.student.svc.ScholarshipModifyService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Scholarship;

public class ScholarshipModifyAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	ScholarshipModifyService scholarshipModifyService = new ScholarshipModifyService();

	@Override
	public void execute(Scanner sc) throws Exception {
			
		String sc_name = consoleUtil.getScholar_name("¼öÁ¤ÇÒ ", sc);
		Scholarship modifyScholarshop = scholarshipModifyService.getModifyScholarship(sc_name);
		
		if(modifyScholarshop == null) {
			consoleUtil.printScholarshipNotFound(sc_name);
			return;
		}
	
		Scholarship changeScholarship = consoleUtil.getChangeScholarship(modifyScholarshop, sc);
		boolean isModifySuccess = scholarshipModifyService.modifyScholarship(changeScholarship);
		
		if(isModifySuccess) {
			consoleUtil.printModifySuccess(changeScholarship);
		}
		else {
			consoleUtil.printModifyFail(changeScholarship);
		}
	}
	
}
