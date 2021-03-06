package io.syndesis.qe.springboot.http.event;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class EventCollector {
	private static EventCollector ourInstance = new EventCollector();
	@Getter
	private static Map<Long, String> events;

	public static EventCollector getInstance() {
		return ourInstance;
	}

	private EventCollector() {
		events = new LinkedHashMap<>();
	}

	public static void recordEvent(String method) {
		events.put(new Date().getTime(), method);
	}

	public static void clearEvents() {
		events.clear();
	}
}
