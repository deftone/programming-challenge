package de.exxcellent.challenge.file;

import de.exxcellent.challenge.file.exceptions.FileTypeNotSupportedException;
import de.exxcellent.challenge.file.reader.CSVFileReader;
import de.exxcellent.challenge.file.reader.IFileReader;
import de.exxcellent.challenge.file.reader.JSONFileReader;

/**
 * Factory (strategy) pattern: use this factory to determine which file reader should be used for the different file types.
 * <p>
 * For now: supported file types are csv and json.
 */
public class FileReaderFactory {
    private static final String CSV = "csv";
    private static final String JSON = "json";
    final static String FILE_TYPE_NOT_SUPPORTED = "Filetype is not supported. File parser exist only for CSV and JSON";

    /** This method determines the file type and returns the correct file reader.
     *  If the file type is not supported (e.g. xml) an exception is thrown.
     *
     * @param fileName  filename of the file that should be read by the fileReader
     * @return          if file type is supported: implementation of file reader interface
     * **/
    public IFileReader getFileReader(String fileName) throws FileTypeNotSupportedException {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }

        switch (extension.toLowerCase()) {
            case CSV:
                return new CSVFileReader();
            case JSON:
                return new JSONFileReader();
            default:
                throw new FileTypeNotSupportedException(FILE_TYPE_NOT_SUPPORTED);
        }
    }
}
