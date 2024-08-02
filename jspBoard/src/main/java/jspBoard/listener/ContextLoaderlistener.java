package jspBoard.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import jspBoard.dao.HikariConnector;

public class ContextLoaderlistener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		
		application.setAttribute("hikari", new HikariConnector(
				application.getInitParameter("driverName"),
				application.getInitParameter("jdbcUrl"), 
				application.getInitParameter("userName"), 
				application.getInitParameter("password")));
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		
		// 다 썼으면 히카리를 부순다
		((HikariConnector) application.getAttribute("hikari")).close();
		
	}

}
