package io.syndesis.qe.springboot.http.controller.swagger.get;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.syndesis.qe.springboot.http.util.ResponseUtil;

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

	@RequestMapping(
			method = RequestMethod.GET,
			path = "/api/getJsonArray",
			produces = "application/json"
	)
	@ResponseBody
	public String getJsonArray() {
		return "["
				+ "{\"key\": \"value1\"},"
				+ "{\"key\": \"value2\"},"
				+ "{\"key\": \"value3\"},"
				+ "{\"key\": \"value4\"},"
				+ "{\"key\": \"value5\"},"
				+ "{\"key\": \"value6\"},"
				+ "{\"key\": \"value7\"},"
				+ "{\"key\": \"value8\"},"
				+ "{\"key\": \"value9\"},"
				+ "{\"key\": \"value10\"}"
				+ "]";
	}
}
