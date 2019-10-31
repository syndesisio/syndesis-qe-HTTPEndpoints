package io.syndesis.qe.springboot.http.controller;

import io.syndesis.qe.springboot.http.event.EventCollector;
import io.syndesis.qe.springboot.http.util.ResponseUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RequestController {
	@RequestMapping(method = RequestMethod.GET, path = "/")
	@ResponseBody
	public String get() {
		return "get";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/")
	@ResponseBody
	public String post(@RequestBody(required = false) String body) {
		return ResponseUtil.bodyOrDefault(body);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/")
	@ResponseBody
	public String put(@RequestBody(required = false) String body) {
		return ResponseUtil.bodyOrDefault(body);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/")
	@ResponseBody
	public String delete(@RequestBody(required = false) String body) {
		return ResponseUtil.bodyOrDefault(body);
	}

	@RequestMapping(method = RequestMethod.PATCH, path = "/")
	@ResponseBody
	public String patch(@RequestBody(required = false) String body) {
		return ResponseUtil.bodyOrDefault(body);
	}

	@RequestMapping(method = RequestMethod.OPTIONS, path = "/")
	@ResponseBody
	public String options() {
		return "options";
	}

	@RequestMapping(method = RequestMethod.TRACE, path = "/")
	@ResponseBody
	public void trace() {
	}

	@RequestMapping(method = RequestMethod.HEAD, path = "/")
	@ResponseBody
	public void head() {
	}

	@RequestMapping(method = RequestMethod.GET, path = "/events")
	@ResponseBody
	public Map<Long, String> getEvents() {
		return EventCollector.getEvents();
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/clearEvents")
	@ResponseBody
	public void clearEvents() {
		EventCollector.clearEvents();
	}
}
