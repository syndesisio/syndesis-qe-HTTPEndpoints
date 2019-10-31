package io.syndesis.qe.springboot.http.controller.swagger.delete;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.syndesis.qe.springboot.http.util.XmlResponse;

@Controller
public class DeleteXml {
	@RequestMapping(
			method = RequestMethod.DELETE,
			path = "/api/deleteXml",
			produces = "application/xml"
	)
	@ResponseBody
	public ResponseEntity<XmlResponse> deleteXml() {
		return ResponseEntity.ok(new XmlResponse("delete"));
	}
}
