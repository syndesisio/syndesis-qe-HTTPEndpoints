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

	@RequestMapping(
			method = RequestMethod.GET,
			path = "/api/getJsonArray",
			produces = "application/json"
	)
	@ResponseBody
	public String getJsonArray() {
		return "["
				+ "{\"key1\": \"value1\"},"
				+ "{\"key2\": \"value2\"},"
				+ "{\"key3\": \"value3\"},"
				+ "{\"key4\": \"value4\"},"
				+ "{\"key5\": \"value5\"},"
				+ "{\"key6\": \"value6\"},"
				+ "{\"key7\": \"value7\"},"
				+ "{\"key8\": \"value8\"},"
				+ "{\"key9\": \"value9\"},"
				+ "{\"key10\": \"value10\"}"
				+ "]";
	}
}
