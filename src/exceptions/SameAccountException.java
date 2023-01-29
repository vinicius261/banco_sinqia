package exceptions;

public class SameAccountException extends RuntimeException {
    public SameAccountException(String msg) {
        super(msg);
    }
}
