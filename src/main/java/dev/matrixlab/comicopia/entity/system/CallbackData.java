package dev.matrixlab.comicopia.entity.system;

import java.io.Serializable;

public class CallbackData<T> implements Serializable {

    private static final long serialVersionUID = -7954752710724421370L;

    private String code;

    private String message;

    private T data;

    public CallbackData() {
    }

    public CallbackData(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CallbackData(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public CallbackData(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CallbackData{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}