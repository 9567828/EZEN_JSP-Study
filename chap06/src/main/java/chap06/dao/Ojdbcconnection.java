package chap06.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ojdbcconnection {
	private String jdbcUrl;
	private String user;
	private String pw;
	
	public Ojdbcconnection(String jdbcUrl, String user, String pw) {
		this.jdbcUrl = jdbcUrl;
		this.user = user;
		this.pw = pw;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, user, pw);
	}
}
