package com.rktest.yy.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rktest.yy.bean.Tuser;
import com.rktest.yy.service.TuserService;

/** 
* @Title: TuserController.java 
* @Package com.rktest.yy.contoller 
* @Description: TODO 
* @author yy
* @date 2019年1月5日 下午3:27:00 
* @version V1.0.0 
*/
@Controller
@RequestMapping("/test")
public class TuserController {
	
	@Autowired
	private TuserService tuserService;
	
	@RequestMapping("/tuser")
	@ResponseBody
	public List<Tuser> getUser() {
		List<Tuser> users = tuserService.getALLUser();
		return users;
	}

	
}

