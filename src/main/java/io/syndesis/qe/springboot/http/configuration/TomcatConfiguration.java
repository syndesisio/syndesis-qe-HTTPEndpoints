package io.syndesis.qe.springboot.http.configuration;

import org.apache.catalina.connector.Connector;

import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * Adds:
 *   - connector customizer that allows TRACE request.
 *   - HTTP connector.
 */
@Component
public class TomcatConfiguration implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
	@Override
	public void customize(TomcatServletWebServerFactory server) {
		server.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> connector.setAllowTrace(true));
		final Connector http = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		http.setPort(8080);
		http.setAllowTrace(true);
		server.addAdditionalTomcatConnectors(http);
	}
}
