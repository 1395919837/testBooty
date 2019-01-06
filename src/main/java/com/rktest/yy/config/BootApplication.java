package com.rktest.yy.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;

/** 
* @Title: BootApplication.java 
* @Package com.rktest.yy.config 
* @Description: TODO 
* @author yy 
* @date 2019年1月5日 上午11:41:19 
* @version V1.0.0 
*/

@Configuration
@PropertySource(value = {"classpath:db.properties"})
@ComponentScan(basePackages = "com.rktest.yy")
@SpringBootApplication
public class BootApplication {
	
	@Value("${jdbc.driver}")
	private String driverClassName;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	//配置数据源
	@Bean(destroyMethod = "close")
	public BoneCPDataSource dataSource(){
		BoneCPDataSource boneCPDataSource = new BoneCPDataSource();
	    // 数据库驱动
	    boneCPDataSource.setDriverClass(driverClassName);
	    // 相应驱动的jdbcUrl
	    boneCPDataSource.setJdbcUrl(url);
	    // 数据库的用户名
	    boneCPDataSource.setUsername(username);
	    // 数据库的密码
	    boneCPDataSource.setPassword(password);
	    // 检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
	    boneCPDataSource.setIdleConnectionTestPeriodInMinutes(60);
	    // 连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
	    boneCPDataSource.setIdleMaxAgeInMinutes(30);
	    // 每个分区最大的连接数
	    boneCPDataSource.setMaxConnectionsPerPartition(100);
	    // 每个分区最小的连接数
	    boneCPDataSource.setMinConnectionsPerPartition(5);
		return boneCPDataSource;
	}
	
	 /**
     * 所有配置信息的入口
     */
	protected SpringApplicationBuilder springApplicationBuilder(SpringApplicationBuilder builder){
	//  激活配置信息
		return builder.sources(BootApplication.class);
	}
	
	
	
	
}

