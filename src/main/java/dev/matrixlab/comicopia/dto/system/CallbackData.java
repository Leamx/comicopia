package dev.matrixlab.comicopia.dto.system;

import lombok.Data;

import java.io.Serializable;

@Data
public class CallbackData implements Serializable {

    private static final long serialVersionUID = -7954752710724421370L;

    private Boolean success;

    private Object data;

    private String message;

    private Integer code;

    private static final ThreadLocal<Object> resource = new ThreadLocal<>();

    private CallbackData() {

    }

    public static CallbackData build(boolean success, Runnable operation) {
        try {
            operation.run();
            CallbackData instance = new CallbackData();
            instance.setSuccess(success);
            instance.setData(null);
            instance.setMessage((String) resource.get());
            instance.setCode(0);
            return instance;
        } finally {
            resource.remove();
        }
    }

    public static CallbackData build(boolean success, Object data) {
        try {
            CallbackData instance = new CallbackData();
            instance.setSuccess(success);
            instance.setData(data);
            instance.setMessage((String) resource.get());
            instance.setCode(0);
            return instance;
        } finally {
            resource.remove();
        }
    }

    public static CallbackData build(boolean success, Object data, String message) {
        CallbackData instance = new CallbackData();
        instance.setSuccess(success);
        instance.setData(data);
        instance.setMessage(message);
        return instance;
    }

    public static CallbackData buildErrorReturn(String message) {
        try {
            CallbackData instance = new CallbackData();
            instance.setSuccess(false);
            instance.setData(resource.get());
            instance.setMessage(message);
            instance.setCode(10);
            return instance;
        } finally {
            resource.remove();
        }
    }

    public static void setResource(Object data) {
        resource.set(data);
    }

}
