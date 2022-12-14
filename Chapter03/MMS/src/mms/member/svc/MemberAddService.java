package mms.member.svc;
//Ʈ������ ó���� �����Ͻ� �� ���� �� �ִ� ���� Convention �̴�.
//��, Connection ��ü�� �����Ͻ� �� ���� �����ؼ� ����ϴ� ���� �Ϲ����̴�.
import static mms.member.db.JdbcUtil.*;
import java.sql.Connection;
import mms.member.dao.MemberDAO;
import mms.member.vo.Member;

public class MemberAddService {

	public boolean addMember(Member newMember) throws Exception{
		// TODO Auto-generated method stub
		boolean isInsertSuccess = false;
		Connection con = getConnection();
		MemberDAO memberDAO = new MemberDAO(con);
		
		int insertCount = memberDAO.insertNewMember(newMember);
		//insertCount : insert �۾��� ������� ��ȯ�Ǵ� ����� �� ��
		if(insertCount > 0){
			commit(con);
			isInsertSuccess = true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		return isInsertSuccess;
		
	}
}



















