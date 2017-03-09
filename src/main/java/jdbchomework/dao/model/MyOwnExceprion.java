package jdbchomework.dao.model;

/**
 * Created by GetFire on 09.03.2017.
 */
public class MyOwnExceprion extends RuntimeException {

    public MyOwnExceprion() {
        super();
    }

    public MyOwnExceprion(String message) {
        super(message);
    }

    public MyOwnExceprion(String message, Throwable cause) {
        super(message, cause);
    }

    public MyOwnExceprion(Throwable cause) {
        super(cause);
    }

    public MyOwnExceprion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
