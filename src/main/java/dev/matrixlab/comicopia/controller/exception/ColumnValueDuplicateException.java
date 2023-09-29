package dev.matrixlab.comicopia.controller.exception;

public class ColumnValueDuplicateException extends RuntimeException {

    private static final long serialVersionUID = 5677026755362235934L;

    public ColumnValueDuplicateException() {
        super();
    }

    public ColumnValueDuplicateException(String message) {
        super(message);
    }

    public ColumnValueDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ColumnValueDuplicateException(Throwable cause) {
        super(cause);
    }

    protected ColumnValueDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
