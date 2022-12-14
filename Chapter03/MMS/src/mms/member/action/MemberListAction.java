package mms.member.action;

import java.util.ArrayList;
import java.util.Scanner;
import mms.member.svc.MemberListService;
import mms.member.util.ConsoleUtil;
import mms.member.vo.Member;

public class MemberListAction implements Action {

	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		ConsoleUtil cu = new ConsoleUtil();
		
		//모델2 개발방식 에서는 실질적인 지비니스로직(사용자의 요청을 처리하는 로직,로그인처리,회원가입 등 ....)
		//은 Service 클래스 에서 처리된다.
		MemberListService memberListService =
				new MemberListService();
			
		//Service 클래스 쪽으로 회원의 목록을 호출하는 부분
		ArrayList<Member> memberList = 
				memberListService.getMemberList();
		
		cu.printMemberList(memberList);		
	}

}











