package mms.member.util;

import java.util.ArrayList;
import java.util.Scanner;
import mms.member.vo.Member;

public class ConsoleUtil {

	public Member getNewMember(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("����� ȸ�� ������ �Է��ϼ���");
		System.out.print("�̸� : ");
		String name = sc.next();
		
		System.out.print("�ּ� : ");
		String addr = sc.next();
		
		System.out.print("�̸��� : ");
		String email = sc.next();
		
		System.out.print("���� : ");
		String nation = sc.next();
		
		System.out.print("���� : ");
		int age = sc.nextInt();
		
		return new Member(name, addr, nation, email, age);
	}

	public void printAddSuccessMessage(Member newMember) {
		// TODO Auto-generated method stub
		System.out.println(newMember.getName() + " ȸ�� ���� �߰� ����");
	}
	
	public void printAddFailMessage(Member newMember) {
		// TODO Auto-generated method stub
		System.out.println(newMember.getName() + " ȸ�� ���� �߰� ����");
	}

	public void printMemberList(ArrayList<Member> memberList) {
		// TODO Auto-generated method stub
		//size() : �÷��ǿ� ����Ǿ� �ִ� ����� ������ �����ϴ� �޼ҵ�
		for(int i=0;i<memberList.size();i++){
			System.out.println(memberList.get(i));
			//�ڹ� ���� ��ü�� + ������ �̷�� ���ų� ��ü�� print �޼ҵ��� �Ķ���ͷ� �����Ǹ�
			//�ش� ��ü�� toString() �޼ҵ尡 �ڵ����� ȣ���.
		}
	}

	public String getName(String msgKind, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println(msgKind + " ȸ���̸��� �Է��ϼ���");
		System.out.print("ȸ���̸� : ");
		return sc.next();
	}

	public Member getUpdateMember(Scanner sc, Member oldMember) {
		// TODO Auto-generated method stub
		System.out.println("������ ȸ�� ������ �Է��ϼ���");
		System.out.print("���� ���� : " + oldMember.getNation());
		System.out.print("������ ���� : ");
		String nation = sc.next();
		
		System.out.print("���� �ּ� : " + oldMember.getAddr());
		System.out.print("������ �ּ� : ");
		String addr = sc.next();
		
		System.out.print("���� �̸��� : " + oldMember.getEmail());
		System.out.print("������ �̸��� : ");
		String email = sc.next();
		
		System.out.print("���� ���� : " + oldMember.getAge());
		System.out.print("������ ���� : ");
		int age = sc.nextInt();
		

		return new Member(oldMember.getName(), addr, nation, email, age);
	}

	public void printModifySuccessMessage(Member updateMember) {
		// TODO Auto-generated method stub
		System.out.println(updateMember.getName() + " ȸ�� ���� ���� ����.");
		
	}
	
	public void printModifyFailMessage(Member updateMember) {
		// TODO Auto-generated method stub
		System.out.println(updateMember.getName() + " ȸ�� ���� ���� ����.");
		
	}

	public void printRemoveSuccessMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " ȸ���� ���� ���� ����.");
	}

	public void printRemoveFailMessage(String name) {
		// TODO Auto-generated method stub
		System.out.println(name + " ȸ���� ���� ���� ����.");
	}
	
}













