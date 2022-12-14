package mms.member.action;

import java.util.Scanner;
import mms.member.svc.MemberAddService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;
//각 요청을 제어하는 클래스
//주로 실질적인 비지니스 로직을 처리하기 전에 필요한 선행작업들을 처리함.
//만약, 웹에서 회원등록 페이지에 정보를 입력하고 회원등록 요청이 넘어왔을 때 페이지에서 넘어오는
//정보를 받는다든지......
public class MemberAddAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception{
		// TODO Auto-generated method stub
		ConsoleUtil cu = new ConsoleUtil();
		Member newMember = cu.getNewMember(sc);
		
		MemberAddService memberAddService =
				new MemberAddService();
		
		boolean isAddSuccess = memberAddService.addMember(newMember);
		
		if(isAddSuccess){
		cu.printAddSuccessMessage(newMember);
		}
		else{
		cu.printAddFailMessage(newMember);	
		}
	}

}












