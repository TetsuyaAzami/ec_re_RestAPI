package com.example.ec_re.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Need login")
public class SessionIdNotFoundException extends RuntimeException {
	public SessionIdNotFoundException() {
		super("ログインしてください");
	}

	public SessionIdNotFoundException(Throwable cause) {
		super("ログインしてください", cause);
	}

	public SessionIdNotFoundException(Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super("ログインしてください", cause, enableSuppression, writableStackTrace);
	}
}
