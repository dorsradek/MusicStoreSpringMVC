package websc.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;


@Configuration
@PropertySource("classpath:/websc/resources/database.properties")
@EnableTransactionManagement
public class DefaultDaoConfiguration implements DaoConfiguration, InitializingBean {

	@Autowired
	Environment env;
	public DefaultDaoConfiguration() {
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	@Bean 
	public DBConnection getDbConnection() {
		DBConnection conn = new DBConnection();
		conn.initialize();
		return conn;
	}
	@Override
	@Bean
	public GenreDao getGenreDao() {
		return new GenreDaoImplementation(this.getDbConnection());
	}
	
	@Override
	@Bean
	public AlbumDao getAlbumDao() {
		return new AlbumDaoImpl(this.getDbConnection());
	}
	
	

}