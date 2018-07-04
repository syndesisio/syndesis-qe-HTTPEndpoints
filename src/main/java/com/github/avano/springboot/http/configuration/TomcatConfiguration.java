package com.github.avano.springboot.http.configuration;

import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * Adds tomcat connector customizer that allows TRACE requests.
 */
@Component
public class TomcatConfiguration implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
	@Override
	public void customize(TomcatServletWebServerFactory server) {
		server.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setAllowTrace(true));
	}
}
