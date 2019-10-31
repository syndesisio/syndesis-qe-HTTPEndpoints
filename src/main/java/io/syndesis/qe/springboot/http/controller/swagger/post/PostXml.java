package io.syndesis.qe.springboot.http.controller.swagger.post;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.syndesis.qe.springboot.http.util.XmlResponse;

@Controller
public class PostXml {
	@RequestMapping(
			method = RequestMethod.POST,
			path = "/api/postXml",
			produces = "application/xml"
	)
	@ResponseBody
	public ResponseEntity<XmlResponse> postXml() {
		return ResponseEntity.ok(new XmlResponse("get"));
	}
}
