package de.exxcellent.challenge.file.exceptions;

/**
 * Exception if the file type is not supported.
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
