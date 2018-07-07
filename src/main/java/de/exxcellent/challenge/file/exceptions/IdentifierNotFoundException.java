package de.exxcellent.challenge.file.exceptions;

/**
 * Exception if not all three parameters are found in the file.
 */
public class IdentifierNotFoundException extends Throwable {
    private String exceptionMessage;

    public IdentifierNotFoundException(String exception) {
        exceptionMessage = exception;
    }

    @Override
    public String getMessage() {
        return exceptionMessage;
    }
}
