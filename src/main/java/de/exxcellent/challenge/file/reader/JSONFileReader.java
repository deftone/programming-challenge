package de.exxcellent.challenge.file.reader;

import de.exxcellent.challenge.file.exceptions.FileException;
import de.exxcellent.challenge.file.exceptions.IdentifierNotFoundException;
import de.exxcellent.challenge.model.FileData;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by deftone on 06.07.18.
 */
public class JSONFileReader implements IFileReader {
    @Override
    public List<FileData> parseFile(String fileName, String qualifier, String comparator1, String comparator2) throws FileException, IdentifierNotFoundException {
        //todo code for json reader
        return new LinkedList<>();
    }


}
