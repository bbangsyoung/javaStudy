package sms.student.action;

import java.util.Scanner;
import sms.student.svc.ScholarshipRegistService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Scholarship;

public class ScholarshipRegistAction implements Action {
	
	ConsoleUtil consoleUtil = new ConsoleUtil();
	ScholarshipRegistService scholarshipRegistService = new ScholarshipRegistService();

	@Override
	public void execute(Scanner sc) throws Exception {
		
		String sc_name = consoleUtil.getScholar_name("ภิทยวา ", sc);
		boolean isRegisted = scholarshipRegistService.searchScholarship(sc_name);
		
		if(isRegisted) {
			consoleUtil.printRegistedScholarship(sc_name);
			return;
		}
		
		Scholarship newScholarship = consoleUtil.getNewScholarShip(sc_name, sc);
		boolean isRegistSuccess = scholarshipRegistService.registScholarship(newScholarship);
		
		if(isRegistSuccess) {
			consoleUtil.printRegistSuccess(newScholarship);
		}
		else {
			consoleUtil.printRegistFail(newScholarship);
		}
	}
	
}
