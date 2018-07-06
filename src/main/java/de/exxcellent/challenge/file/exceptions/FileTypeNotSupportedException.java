package de.exxcellent.challenge.file.exceptions;

/**
 * Created by deftone on 06.07.18.
 */
public class FileTypeNotSupportedException extends Throwable {
    private String exceptionMessage;

    public FileTypeNotSupportedException(String fileTypeNotSupported) {
        exceptionMessage = fileTypeNotSupported;
    }

    @Override
    public String getMessage() {
        return exceptionMessage;
    }
}
