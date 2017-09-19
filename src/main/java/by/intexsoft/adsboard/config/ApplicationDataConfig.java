package by.intexsoft.adsboard.config;

import static org.springframework.orm.jpa.vendor.Database.POSTGRESQL;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("by.intexsoft.adsboard.service")
@PropertySource("classpath:app.properties")
@EnableJpaRepositories("by.intexsoft.adsboard.repository")
public class ApplicationDataConfig {
	@Value("${db.driver}")
	private String driverClassName;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.hibernate.show_sql}")
	private boolean show_sql;
	@Value("${db.hibernate.hbm2ddl.auto}")
	private String hbm2ddl;

	/**
	 * Настройки подключения PostGreSQL
	 * 
	 * @return DataSource
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	/**
	 * Менеджер сущностей
	 * 
	 * @return LocalContainerEntityManagerFactoryBean
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan("by.intexsoft.adsboard.entity");
		entityManagerFactoryBean.setJpaProperties(jpaProperties());
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		return entityManagerFactoryBean;
	}

	/**
	 * JPA provider
	 * 
	 * @return JpaVendorAdapter
	 */
	@Bean
	public JpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(POSTGRESQL);
		adapter.setShowSql(show_sql);
		return adapter;
	}

	/**
	 * Поддержка транзакций
	 * 
	 * @return PlatformTransactionManager
	 */
	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

	private Properties jpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
		return properties;
	}
}
