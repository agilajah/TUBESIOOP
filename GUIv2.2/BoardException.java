/**
 * Created by febiagil on 27/04/16.
 */
public class BoardException extends Exception {
    public BoardException(String message) {
        super(message);
    }

    public BoardException(Throwable cause) {
        super(cause);
    }

    public BoardException(String message, Throwable cause) {
        super(message, cause);
    }

    public BoardException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
