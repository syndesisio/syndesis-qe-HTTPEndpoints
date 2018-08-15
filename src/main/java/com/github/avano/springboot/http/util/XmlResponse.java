package com.github.avano.springboot.http.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.UUID;

import lombok.Getter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlResponse {
	@Getter
	@XmlElement(name = "dummyField1")
	private String dummy1 = UUID.randomUUID().toString();
	@Getter
	@XmlElement(name = "dummyField2")
	private String dummy2 = UUID.randomUUID().toString();
	@Getter
	@XmlElement(name = "method")
	private String method;
	@Getter
	@XmlElement(name = "dummyField3")
	private String dummy3 = UUID.randomUUID().toString();

	public XmlResponse() {
	}

	public XmlResponse(String method) {
		this.method = method;
	}
}
