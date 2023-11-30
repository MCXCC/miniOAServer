package com.amtr.minioaserver.pojo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Result extends ResponseEntity<Message> {

    public Result(HttpStatus status) {
        super(status);
    }

    public Result(String code, String msg, Object data) {
        super(Message.custom(code, msg, data), Message.num2HttpStatus(code));
    }

    public Result(String code, String msg) {
        super(Message.custom(code, msg), Message.num2HttpStatus(code));
    }

    public static Result success(Object data) {
        return new Result("200", "成功", data);
    }

    public static Result success() {
        return new Result("200", "成功");
    }

    public static Result failed(Object data) {
        return new Result("422", "失败", data);
    }

    public static Result failMsg(String msg) {
        return new Result("422", msg);
    }

    public static Result noLogin() {
        return new Result("401", "NO_LOGIN");
    }

    public static Result custom(String code, String msg, Object data) {
        return new Result(code, msg, data);
    }
}

class Message {

    String status;
    //向前端返回的内容
    String message;

    Object data;

    public Message() {
    }

    public Message(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public Message(String status, String message, Object data) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public static Message custom(String status, String message, Object data) {
        return new Message(status, message, data);
    }

    public static Message custom(String status, String message) {
        return new Message(status, message);
    }

    public static HttpStatus num2HttpStatus(String code) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        for (HttpStatus httpStatus : HttpStatus.values()) {
            boolean b = Integer.parseInt(code) == httpStatus.value();
            if (b) {
                return httpStatus;
            }
        }
        return status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
