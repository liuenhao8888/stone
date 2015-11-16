package com.stone.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stone.user.model.TAdmin;

@Controller
public class IndexController {

	protected static final Logger log = Logger.getLogger(IndexController.class);
	
	@RequestMapping(value="index")
	private String add(HttpServletRequest request,TAdmin admin) {
		return "front/index";
	}

}
