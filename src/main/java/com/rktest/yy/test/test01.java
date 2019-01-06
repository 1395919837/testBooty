package com.rktest.yy.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.rktest.yy.mapper.TuserMapper;
import com.rktest.yy.service.impl.TuserServiceImpl;

/** 
* @Title: test01.java 
* @Package com.rktest.yy.test 
* @Description: TODO 
* @author yy
* @date 2019年1月5日 下午3:57:59 
* @version V1.0.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class test01 {
	
	@Autowired
	private ApplicationContext context;
	
	@Test
	public void test(){
		System.out.println(context.getBean(TuserMapper.class));
	}
	

}

