import java.io.IOException;

/**
 * Created by julia on 03-Mar-17.
 */
public class FileHasErrorsException extends IOException {
    public FileHasErrorsException() {
    }

    public FileHasErrorsException(String message) {
        super(message);
    }
}
