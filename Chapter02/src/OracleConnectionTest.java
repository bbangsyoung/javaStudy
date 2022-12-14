import java.sql.*;
public class OracleConnectionTest {
	static{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
		String userID = "javaDB";
		String userPass = "javaDB";
		Connection con = null;
		try{
		con = DriverManager.getConnection(jdbcUrl,userID,userPass);
		System.out.println("connection success");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
