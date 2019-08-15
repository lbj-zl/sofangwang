package com.imooc.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
    private int code;

    private String message;

    private Object data;

    private boolean more;

    public ApiResponse() {
        this.code = Status.SUCCESS.getCode();
        this.message = Status.SUCCESS.getStandardMessage();
    }

    public ApiResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ApiResponse ofMessage(int code, String message) {
        return new ApiResponse(code, message, null);
    }

    public static ApiResponse ofSuccess(Object data) {
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.getStandardMessage(), data);
    }

    public static ApiResponse ofStatus(Status status) {
        return new ApiResponse(status.getCode(), status.getStandardMessage(), null);
    }

    @Getter
    @AllArgsConstructor
    public enum Status {
        SUCCESS(200, "OK"),

        BAD_REQUEST(400, "Bad Request"),

        NOT_FOUND(404, "NOT_FOUND"),

        INTERNAL_SERVER_ERROR(500, "Unknown Internal Error"),

        NOT_VALID_PARAM(40005, "Not Valid Params"),

        NOT_SUPPORT_OPERATION(40060, "Operation Not Supported"),

        NOT_LOGIN(50000,"Not Login");

        private int code;

        private String StandardMessage;
    }

}
