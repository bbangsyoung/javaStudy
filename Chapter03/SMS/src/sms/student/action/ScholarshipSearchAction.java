package sms.student.action;

import java.util.ArrayList;
import java.util.Scanner;
import sms.student.controller.StudentController;
import sms.student.svc.ScholarshipSearchService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Scholarship;

public class ScholarshipSearchAction implements Action {
	
	ConsoleUtil consoleUtil = new ConsoleUtil();
	ScholarshipSearchService scholarshipSearchService = new ScholarshipSearchService();

	@Override
	public void execute(Scanner sc) throws Exception {
	
		int searchMenuNum = consoleUtil.getSearchMenuNumScholarship(sc);
		ArrayList<Scholarship> searchScholarshipList = null;

		if(searchMenuNum==1){
			String sc_name = consoleUtil.getScholar_name("검색할 ", sc);
			searchScholarshipList = scholarshipSearchService.getSearchScholarshipListBySc_name(sc_name);
		}
		else if(searchMenuNum==2){
			int money = consoleUtil.getMoney("검색할 ", sc);
			searchScholarshipList = scholarshipSearchService.getSearchScholarshipListByMoney(money);
		}
		else {
			consoleUtil.printSearchMenuNumWrong();
			Action action = new ScholarshipSearchAction();
			StudentController studentController = new StudentController();
			studentController.requestProcess(action, sc);
			return;
		}

		if(searchScholarshipList!=null) {
			consoleUtil.printScholarshipList(searchScholarshipList);
		}
		else {
			consoleUtil.printSearchScholarshipListNotFound();
		}	
	}
	
}
