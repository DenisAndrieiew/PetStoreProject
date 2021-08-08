package com.goit.petStoreProject.model.Data;

public class ApiResponse {
    int code;
    String type;
    String message;

    public ApiResponse(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ApiResponse: {" +
                "\n\t\tcode=" + code +
                ",\n\t\t type='" + type + '\'' +
                ",\n\t\t message='" + message + '\'' +
                "\n\t\t\t}";
    }
}
