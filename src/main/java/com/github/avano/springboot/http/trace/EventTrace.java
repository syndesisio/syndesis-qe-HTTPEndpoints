package com.github.avano.springboot.http.trace;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.stereotype.Repository;

import com.github.avano.springboot.http.event.EventCollector;

@Repository
public class EventTrace extends InMemoryHttpTraceRepository {
	@Override
	public void add(HttpTrace trace) {
		if ("/".equals(trace.getRequest().getUri().getPath())) {
			EventCollector.recordEvent(trace.getRequest().getMethod());
		}
	}
}
