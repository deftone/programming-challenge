package de.exxcellent.challenge.file.reader;

import de.exxcellent.challenge.file.exceptions.FileException;
import de.exxcellent.challenge.file.exceptions.IdentifierNotFoundException;
import de.exxcellent.challenge.model.FileData;

import java.util.List;

/**
 * Interface to use different file readers, depending on the file type (json, csv, ...) (strategy pattern)
 */
public interface IFileReader {

    /**
     * This method reads a file and parses the content of that file for the vales of the desired paramters.
     * If the file can not be read (found/opened) an exception is thrown.
     * If the desired parameters can not be found in the file content, an exception is thrown.
     *
     * @param fileName      name of that file
     * @param qualifier     name of qualifier (first desired parameter, e.g. "team")
     * @param comparator1   name of first comparator (second desired parameter, e.g. "goals")
     * @param comparator2   name of second comparator (third desired parameter, e.g. "goals allowed")
     * @return              a List that contains objects of the values of these desired parameters
     * **/
    List<FileData> parseFile(final String fileName, final String qualifier, final String comparator1,
                             final String comparator2) throws FileException, IdentifierNotFoundException;
}
