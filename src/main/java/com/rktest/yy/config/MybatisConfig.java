package com.rktest.yy.config;


import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/** 
* @Title: MybatisConfig.java 
* @Package com.rktest.yy.config 
* @Description: TODO 
* @author yy 
* @date 2019年1月5日 下午12:04:39 
* @version V1.0.0 
*/

@Configuration
public class MybatisConfig {
	
	@Bean
	@ConditionalOnMissingBean  // 当容器里没有指定的Bean的情况下创建该对象
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		// 设置数据源
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		//设置mybatis的mapper.xml
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = null;
		try {
			resources =resolver.getResources("classpath:mapper/*Mapper.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(resources !=null){
			sqlSessionFactoryBean.setMapperLocations(resources);
		}
		// 设置别名包
		sqlSessionFactoryBean.setTypeAliasesPackage("com.rktest.yy.bean");
		return sqlSessionFactoryBean;
	}

	
}

