package io.syndesis.qe.springboot.http.controller.swagger.put;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.syndesis.qe.springboot.http.util.XmlResponse;

@Controller
public class PutXml {
	@RequestMapping(
			method = RequestMethod.PUT,
			path = "/api/putXml",
			produces = "application/xml"
	)
	@ResponseBody
	public ResponseEntity<XmlResponse> putXml() {
		return ResponseEntity.ok(new XmlResponse("get"));
	}
}
