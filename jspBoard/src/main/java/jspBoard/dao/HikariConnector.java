package jspBoard.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnector {
	
	private HikariDataSource dataSource;
	
	public HikariConnector(String drivername, String jdbcUrl, String username, String password) {
		HikariConfig config = new HikariConfig();
		
		System.out.println("divername: " + drivername);
		System.out.println("jdbcUrl: " + jdbcUrl);
		System.out.println("username: " + username);
		System.out.println("pw: " + password);
		
		config.setDriverClassName(drivername);
		config.setJdbcUrl(jdbcUrl);
		config.setUsername(username);
		config.setPassword(password);
		
		dataSource = new HikariDataSource(config);
	}
	
	public Connection getConnecion() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void close() {
		dataSource.close();
	}

}
