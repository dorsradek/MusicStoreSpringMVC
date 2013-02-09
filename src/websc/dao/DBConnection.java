package websc.dao;

import java.sql.Date;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnection {
	
	private String			dbDriver		= "org.postgresql.Driver";
	private String			dbName			= "musicStore";
	private String			dbHost			= "localhost";
	private int				dbPort			= 5432;

	private String			dbUser			= "aramos";
	private String			dbPassword		= "aramos";
	private int				initialSize		= 5;
	
	private ComboPooledDataSource	dataSource;
	private JdbcTemplate	jdbcTemplate;
	private boolean			isSetup			= false;
	
	public void initialize() {
		dataSource = new ComboPooledDataSource();
		try {
			if (dbDriver.equals("oracle.jdbc.driver.OracleDriver")) {
				dataSource.setJdbcUrl(String.format("jdbc:oracle:thin:@%s:%s:%s", dbHost, dbPort, dbName));
				dataSource.setDriverClass(dbDriver);
			} else if (dbDriver.equals("org.postgresql.Driver")) {
				// org.postgresql.Driver
				dataSource.setJdbcUrl(String.format("jdbc:postgresql://%s:%s/%s", dbHost, dbPort, dbName));
				dataSource.setDriverClass(dbDriver);
			} else {
				return;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
		dataSource.setUser(dbUser);
		dataSource.setPassword(dbPassword);
		dataSource.setMinPoolSize(initialSize);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private boolean isSetup() {
		if (isSetup) {
			return isSetup;
		} else {
			try {
				if (dbDriver.equals("org.postgresql.Driver")) {
					jdbcTemplate.queryForObject("select now()", Date.class);
				} else if (dbDriver.equals("oracle.jdbc.driver.OracleDriver")) {
					jdbcTemplate.queryForObject("select sysdate from dual", Date.class);
				}
				isSetup = true;
			} catch (Exception e) {
				e.printStackTrace();
				isSetup = false;

			}
			return isSetup;
		}
	}
	
	JdbcTemplate getTemplate() {
		return this.jdbcTemplate;
	}
}
