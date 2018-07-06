package de.exxcellent.challenge.file;

/**
 * Created by deftone on 06.07.18.
 */
public class FileException extends Throwable {
    private String exceptionMessage;

    public FileException(String exception) {
       exceptionMessage = exception;
    }

    @Override
    public String getMessage() {
        return exceptionMessage;
    }
}
