package io.syndesis.qe.springboot.http.controller.swagger.post;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.syndesis.qe.springboot.http.util.ResponseUtil;

@Controller
public class PostJson {
	@RequestMapping(
			method = RequestMethod.POST,
			path = "/api/postJson",
			produces = "application/json"
	)
	@ResponseBody
	public String postJson() {
		return ResponseUtil.getJsonResponse("post");
	}
}
