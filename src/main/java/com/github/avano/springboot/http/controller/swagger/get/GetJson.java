package com.github.avano.springboot.http.controller.swagger.get;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.avano.springboot.http.util.ResponseUtil;

@Controller
public class GetJson {
	@RequestMapping(
			method = RequestMethod.GET,
			path = "/api/getJson",
			produces = "application/json"
	)
	@ResponseBody
	public String getJson() {
		return ResponseUtil.getJsonResponse("get");
	}
}
