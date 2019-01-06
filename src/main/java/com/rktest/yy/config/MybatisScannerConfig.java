package com.rktest.yy.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** 
* @Title: MybatisScannerConfig.java 
* @Package com.rktest.yy.config 
* @Description: TODO 
* @author yy
* @date 2019年1月5日 下午12:24:32 
* @version V1.0.0 
*/
@Configuration
@AutoConfigureAfter(MybatisConfig.class) // 保证在MybatisConfig类实例化后才实例化此方法
public class MybatisScannerConfig {
	// mapper接口的扫描器
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.rktest.yy.mapper");
		return mapperScannerConfigurer;
	}
}

