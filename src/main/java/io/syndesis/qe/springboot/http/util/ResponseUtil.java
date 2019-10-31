package io.syndesis.qe.springboot.http.util;

import java.util.UUID;

public final class ResponseUtil {
	private ResponseUtil() {
	}

	/**
	 * Returns the body (if specified) or the name of the caller method.
	 *
	 * @param body body
	 * @return body if null, caller method name otherwise
	 */
	public static String bodyOrDefault(String body) {
		if (body == null || body.isEmpty()) {
			return Thread.currentThread().getStackTrace()[2].getMethodName();
		} else {
			return body;
		}
	}

	/**
	 * Returns the json response with dummy field and used HTTP method.
	 * @param method http method
	 * @return json
	 */
	public static String getJsonResponse(String method) {
		return String.format("{\"dummyField1\":\"%s\",\"dummyField2\":\"%s\",\"method\":\"%s\",\"dummyField3\":\"%s\"}",
				UUID.randomUUID().toString(), UUID.randomUUID().toString(), method, UUID.randomUUID().toString());
	}
}
