package mms.member.action;

import java.util.Scanner;
import mms.member.svc.MemberRemoveService;
import mms.member.util.ConsoleUtil;

public class MemberRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		ConsoleUtil cu = new ConsoleUtil();
		
		String name = cu.getName("ªË¡¶«“ ", sc);
		MemberRemoveService memberRemoveService
		= new MemberRemoveService();
		
		boolean removeSuccess = memberRemoveService.removeMember(name);
		
		if(removeSuccess){
			cu.printRemoveSuccessMessage(name);
		}
		else{
			cu.printRemoveFailMessage(name);
		}
	}

}

















