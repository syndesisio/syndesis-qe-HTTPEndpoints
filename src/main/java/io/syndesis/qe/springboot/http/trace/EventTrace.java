package io.syndesis.qe.springboot.http.trace;

import io.syndesis.qe.springboot.http.event.EventCollector;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class EventTrace extends InMemoryHttpTraceRepository {
	@Override
	public void add(HttpTrace trace) {
		if ("/".equals(trace.getRequest().getUri().getPath()) || trace.getRequest().getUri().getPath().contains("/api/")) {
			EventCollector.recordEvent(trace.getRequest().getMethod() + " " + trace.getRequest().getUri().getPath());
		}
	}
}
