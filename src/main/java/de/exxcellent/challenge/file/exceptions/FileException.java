package de.exxcellent.challenge.file.exceptions;

/**
 * Exception if file can not be found, can not be read or is not a file.
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
