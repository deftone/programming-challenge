package de.exxcellent.challenge.file.reader;

import de.exxcellent.challenge.file.exceptions.FileException;
import de.exxcellent.challenge.file.exceptions.IdentifierNotFoundException;
import de.exxcellent.challenge.model.FileData;

import java.util.ArrayList;

/**
 * Created by deftone on 06.07.18.
 */
public interface IFileReader {

    ArrayList<FileData> parseFile(final String fileName, final String qualifier, final String comparator1,
                                  final String comparator2) throws FileException, IdentifierNotFoundException;
}
