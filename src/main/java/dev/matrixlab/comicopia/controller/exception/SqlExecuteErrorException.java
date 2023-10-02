package dev.matrixlab.comicopia.controller.exception;

public class SqlExecuteErrorException extends RuntimeException {

    private static final long serialVersionUID = 3151834783061150516L;

    public SqlExecuteErrorException() {
        super();
    }

    public SqlExecuteErrorException(String message) {
        super(message);
    }

    public SqlExecuteErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlExecuteErrorException(Throwable cause) {
        super(cause);
    }

    protected SqlExecuteErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
