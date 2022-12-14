package mms.member.svc;
//트렌젝션 처리는 비지니스 단 에서 해 주는 것이 Convention 이다.
//즉, Connection 객체는 비지니스 단 에서 생성해서 사용하는 것이 일반적이다.
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
		//insertCount : insert 작업이 수행된후 반환되는 적용된 행 수
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



















