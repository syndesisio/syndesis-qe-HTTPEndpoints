package com.github.avano.springboot.http.util;

public final class ResponseUtil {
	/**
	 * Returns the body (if specified) or the name of the caller method.
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
}
