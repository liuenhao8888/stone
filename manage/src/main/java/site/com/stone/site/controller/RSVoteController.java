package com.stone.site.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stone.base.controller.BaseController;
import com.stone.base.exception.BusinessException;
import com.stone.site.model.RSVote;
import com.stone.site.service.IRSVoteService;

@Controller
public class RSVoteController extends BaseController {

	@Resource(name = "rsvoteService")
	private IRSVoteService rsvoteService;

	@RequestMapping(value = "rsv/vote", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> vote(HttpServletRequest rqs, RSVote rsv)
			throws BusinessException {
		rsv.setIp(getIpAddr(rqs));
		int length = this.rsvoteService.vote(rsv);
		Map<String, Object> modelMap = new HashMap<String, Object>(1);
		modelMap.put("length", length);
		return modelMap;
	}

}
