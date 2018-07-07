package de.exxcellent.challenge.file.reader;

import de.exxcellent.challenge.file.exceptions.FileException;
import de.exxcellent.challenge.file.exceptions.IdentifierNotFoundException;
import de.exxcellent.challenge.model.FileData;

import java.util.List;

/**
 * Created by deftone on 06.07.18.
 */
public interface IFileReader {

    List<FileData> parseFile(final String fileName, final String qualifier, final String comparator1,
                             final String comparator2) throws FileException, IdentifierNotFoundException;
}
