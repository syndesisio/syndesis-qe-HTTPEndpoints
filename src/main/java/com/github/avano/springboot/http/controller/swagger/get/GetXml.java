package com.github.avano.springboot.http.controller.swagger.get;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.avano.springboot.http.util.XmlResponse;

@Controller
public class GetXml {
	@RequestMapping(
			method = RequestMethod.GET,
			path = "/api/getXml",
			produces = "application/xml"
	)
	@ResponseBody
	public ResponseEntity<XmlResponse> getXml() {
		return ResponseEntity.ok().body(new XmlResponse("get"));
	}
}
