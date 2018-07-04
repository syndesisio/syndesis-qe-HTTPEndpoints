package com.github.avano.springboot.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RequestController {
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String get() {
		log.info("GET executed");
		return "get";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String post() {
		log.info("POST executed");
		return "post";
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public String put() {
		log.info("PUT executed");
		return "put";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public String delete() {
		log.info("DELETE executed");
		return "delete";
	}

	@RequestMapping(method = RequestMethod.PATCH)
	@ResponseBody
	public String patch() {
		log.info("PATCH executed");
		return "patch";
	}

	@RequestMapping(method = RequestMethod.OPTIONS)
	@ResponseBody
	public String options() {
		log.info("OPTIONS executed");
		return "options";
	}

	@RequestMapping(method = RequestMethod.TRACE)
	@ResponseBody
	public void trace() {
		log.info("TRACE executed");
		// Standard TRACE output
	}

	@RequestMapping(method = RequestMethod.HEAD)
	@ResponseBody
	public void head() {
		log.info("HEAD executed");
		// Standard HEAD output
	}
}
