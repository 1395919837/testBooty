package com.rktest.yy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rktest.yy.bean.Tuser;
import com.rktest.yy.mapper.TuserMapper;
import com.rktest.yy.service.TuserService;

/** 
* @Title: TuserServiceImpl.java 
* @Package com.rktest.yy.service.impl 
* @Description: TODO 
* @author yy
* @date 2019年1月5日 下午3:16:33 
* @version V1.0.0 
*/
@Service("tuserService")
public class TuserServiceImpl implements TuserService{
	
	@Autowired
	private TuserMapper tuserMapper;
	
	@Override
	public List<Tuser> getALLUser() {
		return tuserMapper.getAllUser();
	}

}

