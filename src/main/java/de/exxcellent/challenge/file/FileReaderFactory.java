package de.exxcellent.challenge.file;

import de.exxcellent.challenge.file.exceptions.FileTypeNotSupportedException;
import de.exxcellent.challenge.file.reader.CSVFileReader;
import de.exxcellent.challenge.file.reader.IFileReader;
import de.exxcellent.challenge.file.reader.JSONFileReader;

import static de.exxcellent.challenge.model.Constants.CSV;
import static de.exxcellent.challenge.model.Constants.FILE_TYPE_NOT_SUPPORTED;
import static de.exxcellent.challenge.model.Constants.JSON;

/**
 * Factory (strategy) pattern: use this factory to determine which file reader should be used for the different file types.
 * <p>
 * For now: supported file types are csv and json.
 */
public class FileReaderFactory {

    /**
     * This method determines the file type and returns the correct file reader.
     * If the file type is not supported (e.g. xml) an exception is thrown.
     *
     * @param fileName filename of the file that should be read by the fileReader
     * @return if file type is supported: implementation of file reader interface
     **/
    public IFileReader getFileReader(String fileName) throws FileTypeNotSupportedException {

        if (fileName.toLowerCase().endsWith(CSV)) {
            return new CSVFileReader();
        }

        if (fileName.toLowerCase().endsWith(JSON)) {
            return new JSONFileReader();
        }

        throw new FileTypeNotSupportedException(FILE_TYPE_NOT_SUPPORTED);
    }
}
