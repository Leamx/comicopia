package dev.matrixlab.comicopia.utils;

import dev.matrixlab.comicopia.entity.system.CallbackData;

public class CallbackUtils {

    public static <T> CallbackData<T> success(String message) {
        return new CallbackData<>("00000", message, null);
    }

    public static <T> CallbackData<T> success(T data) {
        return new CallbackData<>("00000", "success", data);
    }

    public static <T> CallbackData<T> error(String message) {
        return error("A0500", message);
    }

    public static <T> CallbackData<T> error(String code, String message) {
        return new CallbackData<>(code, message, null);
    }

}
