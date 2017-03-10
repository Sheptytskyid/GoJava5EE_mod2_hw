package jdbchomework.dao.model;

public class ProblemDbConnection extends RuntimeException {

    public ProblemDbConnection() {
        super();
    }

    public ProblemDbConnection(String message) {
        super(message);
    }

    public ProblemDbConnection(String message, Throwable cause) {
        super(message, cause);
    }

    public ProblemDbConnection(Throwable cause) {
        super(cause);
    }

    public ProblemDbConnection(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
