package mms.member.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	static{
		//클래스가 로딩될 때 단 한번 호출되는 영역
		//Class.forName : 특정 클래스를 메모리로 로딩하는 메소드
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		//디비 작업에 필요한 Connection 객체를 생성해 주는 메소드
		Connection con = null;
		try{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",
					"javaDB","javaDB");
			con.setAutoCommit(false);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con){
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt){
		try{
			stmt.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs){
		try{
			rs.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//transaction 처리 메소드
	public static void commit(Connection con){
		try{
			con.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con){
		try{
			con.rollback();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}




















