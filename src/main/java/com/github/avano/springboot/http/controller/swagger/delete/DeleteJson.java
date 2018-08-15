package com.github.avano.springboot.http.controller.swagger.delete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.avano.springboot.http.util.ResponseUtil;

@Controller
public class DeleteJson {
	@RequestMapping(
			method = RequestMethod.DELETE,
			path = "/api/deleteJson",
			produces = "application/json"
	)
	@ResponseBody
	public String deleteJson() {
		return ResponseUtil.getJsonResponse("delete");
	}
}
