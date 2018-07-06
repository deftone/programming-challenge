package de.exxcellent.challenge.file.exceptions;

/**
 * Created by deftone on 06.07.18.
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
