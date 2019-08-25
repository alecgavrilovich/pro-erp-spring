package com.alecgavrilovich.procurement.dao;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {

	private static final String DB_USERNAME="alec_student";
	private static final String DB_PASSWORD="kikilija1056";
	private static final String DB_URL="jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DB_DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";
	
	private static BasicDataSource dataSource;
	
	static {
		try {
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(DB_DRIVER_CLASS);
			dataSource.setUrl(DB_URL);
			dataSource.setUsername(DB_USERNAME);
			dataSource.setPassword(DB_PASSWORD);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static BasicDataSource getDataSource() {
		return dataSource;
	}
}