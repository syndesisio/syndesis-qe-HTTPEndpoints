package com.github.avano.springboot.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.avano.springboot.http.event.Event;
import com.github.avano.springboot.http.event.EventCollector;

import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RequestController {
	@Event
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String get() {
		return "get";
	}

	@Event
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String post() {
		return "post";
	}

	@Event
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public String put() {
		return "put";
	}

	@Event
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public String delete() {
		return "delete";
	}

	@Event
	@RequestMapping(method = RequestMethod.PATCH)
	@ResponseBody
	public String patch() {
		return "patch";
	}

	@Event
	@RequestMapping(method = RequestMethod.OPTIONS)
	@ResponseBody
	public String options() {
		return "options";
	}

	@Event
	@RequestMapping(method = RequestMethod.TRACE)
	@ResponseBody
	public void trace() {
		// Standard TRACE output
	}

	@Event
	@RequestMapping(method = RequestMethod.HEAD)
	@ResponseBody
	public void head() {
		// Standard HEAD output
	}

	@RequestMapping(method = RequestMethod.GET, path = "/events")
	@ResponseBody
	public Map<Long, String> getEvents() {
		return EventCollector.getEvents();
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/clearEvents")
	public void clearEvents() {
		EventCollector.clearEvents();
	}
}
