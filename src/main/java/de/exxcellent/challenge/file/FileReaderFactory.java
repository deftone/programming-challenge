package de.exxcellent.challenge.file;

import de.exxcellent.challenge.file.exceptions.FileTypeNotSupportedException;
import de.exxcellent.challenge.file.reader.CSVFileReader;
import de.exxcellent.challenge.file.reader.IFileReader;
import de.exxcellent.challenge.file.reader.JSONFileReader;

/**
 * Created by deftone on 06.07.18.
 */
public class FileReaderFactory {
    //supported filtypes:
    private static final String CSV = "csv";
    private static final String JSON = "json";
    final static String FILE_TYPE_NOT_SUPPORTED = "Filetype is not supported. File parser exist only for CSV and JSON";

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
