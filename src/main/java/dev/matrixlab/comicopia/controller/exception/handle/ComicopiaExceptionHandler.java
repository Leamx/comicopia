package dev.matrixlab.comicopia.controller.exception.handle;

import dev.matrixlab.comicopia.controller.exception.ColumnValueDuplicateException;
import dev.matrixlab.comicopia.entity.system.CallbackData;
import dev.matrixlab.comicopia.utils.CallbackUtils;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ComicopiaExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(ComicopiaExceptionHandler.class);

    @ExceptionHandler({ColumnValueDuplicateException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CallbackData<String> handlerColumnValueDuplicateException(Exception exception) {
        return CallbackUtils.error(exception.getMessage());
    }

    @ExceptionHandler({InternalException.class})
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public CallbackData<String> handlerInternalException(Exception exception) {
        return CallbackUtils.error(exception.getMessage());
    }

}
