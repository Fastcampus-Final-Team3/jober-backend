package com.javajober.core.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ApiStatus {

	OK(HttpStatus.OK,  "succeeded request"),
	FILE_UPLOAD_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "file upload fail"),
	FILE_DELETE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "file delete fail"),
	FILE_DOWNLOAD_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "file download fail"),
	FILE_PROCESSING_NOT_SUPPORTED(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "file processing not supported"),
	INVALID_DATA(HttpStatus.BAD_REQUEST, "invalid data"),
	EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "exception"),
	IO_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR, "io exception"),
	NO_PERMISSION(HttpStatus.UNAUTHORIZED, "no permission"),
	ALREADY_EXIST(HttpStatus.CONFLICT, "already data exists"),
	FAIL(HttpStatus.INTERNAL_SERVER_ERROR, "failed request"),
	OBJECT_EMPTY(HttpStatus.BAD_REQUEST, "object is empty"),
	INVALID_DATE(HttpStatus.BAD_REQUEST, "invalid date"),
	NOT_FOUND(HttpStatus.NOT_FOUND, "data not found"),
	PAYLOAD_TOO_LARGE(HttpStatus.PAYLOAD_TOO_LARGE, "Payload Too Large"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "login token expire"),
	FORBIDDEN(HttpStatus.FORBIDDEN, "forbidden");;

	private final HttpStatus httpStatus;
	private final String message;

	ApiStatus(HttpStatus httpStatus, String message) {
		this.httpStatus = httpStatus;
		this.message = message;
	}
}
