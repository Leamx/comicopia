package dev.matrixlab.comicopia.dto.system;

import lombok.Data;

import java.io.Serializable;

@Data
public class CallbackDataDTO implements Serializable {

    private static final long serialVersionUID = -7954752710724421370L;

    private Boolean success;

    private Object data;

    private String message;

    private String code;

    private static final ThreadLocal<Object> resource = new ThreadLocal<>();

    private CallbackDataDTO() {

    }

    public static CallbackDataDTO build(boolean success) {
        try {
            CallbackDataDTO instance = new CallbackDataDTO();
            instance.setSuccess(success);
            instance.setMessage((String) resource.get());
            instance.setCode("0");
            return instance;
        } finally {
            resource.remove();
        }
    }

    public static CallbackDataDTO build(boolean success, Object data) {
        try {
            CallbackDataDTO instance = new CallbackDataDTO();
            instance.setSuccess(success);
            instance.setData(data);
            instance.setMessage((String) resource.get());
            instance.setCode("0");
            return instance;
        } finally {
            resource.remove();
        }
    }

    public static CallbackDataDTO build(boolean success, Object data, String message) {
        CallbackDataDTO instance = new CallbackDataDTO();
        instance.setSuccess(success);
        instance.setData(data);
        instance.setMessage(message);
        return instance;
    }

    public static CallbackDataDTO buildErrorReturn(String message) {
        try {
            CallbackDataDTO instance = new CallbackDataDTO();
            instance.setSuccess(false);
            instance.setData(resource.get());
            instance.setMessage(message);
            instance.setCode("10");
            return instance;
        } finally {
            resource.remove();
        }
    }

}
