package model;

/**
 * Created by febiagil on 27/04/16.
 */
public class ImageException extends Exception {

    /**
     * Image Exception constructor.
     * @param message as the message that will be thrown
     */
    public ImageException(String message) {
        super(message);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
