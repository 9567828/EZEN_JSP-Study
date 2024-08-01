package loginCRUD.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private String dbUrl;
	private String user;
	private String pw;
	
	public DBconnection(String dbUrl, String user, String pw) {
		this.dbUrl = dbUrl;
		this.user = user;
		this.pw = pw;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, user, pw);
	}
}
