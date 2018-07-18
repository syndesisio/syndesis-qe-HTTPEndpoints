package com.github.avano.springboot.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.avano.springboot.http.event.EventCollector;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RequestController {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String get() {
		return "get";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String post() {
		return "post";
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public String put() {
		return "put";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public String delete() {
		return "delete";
	}

	@RequestMapping(method = RequestMethod.PATCH)
	@ResponseBody
	public String patch() {
		return "patch";
	}

	@RequestMapping(method = RequestMethod.OPTIONS)
	@ResponseBody
	public String options() {
		return "options";
	}

	@RequestMapping(method = RequestMethod.TRACE)
	@ResponseBody
	public void trace() {
	}

	@RequestMapping(method = RequestMethod.HEAD)
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
