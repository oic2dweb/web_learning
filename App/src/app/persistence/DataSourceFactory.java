package app.persistence;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DataSourceFactory {
	
	private static DataSource dataSource = null;
	
	static{
		dataSource = getInstance();
	}
		
	private DataSourceFactory() {}
	
	public static DataSource getDataSource(){
		return dataSource;
	}

	private static DataSource getInstance(){
		
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql:///web_learning_system?useUnicode=true&characterEncoding=utf8");
		config.setUsername("root");
		config.setPassword("");
		config.addDataSourceProperty("dataSourceClassName", "com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		
		return new HikariDataSource(config);
	}
}
