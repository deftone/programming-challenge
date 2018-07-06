package de.exxcellent.challenge.file.reader;

import de.exxcellent.challenge.file.exceptions.FileException;
import de.exxcellent.challenge.file.exceptions.IdentifierNotFoundException;
import de.exxcellent.challenge.model.FileData;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static de.exxcellent.challenge.file.reader.CSVFileReader.FILE_NOT_FOUND_EXCEPTION;
import static de.exxcellent.challenge.file.reader.CSVFileReader.IDENTIFIER_NOT_FOUND_EXCEPTION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by deftone on 05.07.18.
 */
public class CSVFileReaderTest{

    private final static String WORKING_FILE = "src/main/resources/de/exxcellent/challenge/weather.csv";
    private final static String NO_FILE = "noFileHere.txt";

    private final static String one = "one";
    private final static String two = "two";
    private final static String three = "three";
    private final static String four = "four";
    private final static String five = "five";
    private final static String FIVE = "FIVE";
    private final static String[] dataItems = {one, two, three, four, five};
    private CSVFileReader reader;

    @Before
    public void setUp() {
        reader = new CSVFileReader();
    }

    @Test
    public void determineIndicesSuccess() {
        //case insenstive!
        assertEquals(true, reader.determineIndices(dataItems, one, FIVE, three));
        assertEquals(4, reader.getIndexComparator1());
    }

    @Test
    public void determineIndicesFailure() {
        assertEquals(false, reader.determineIndices(dataItems, "xxx", two, four));
        assertEquals(1, reader.getIndexComparator1());
    }

    @Test
    public void parseCSVFileSuccess() throws FileException, IdentifierNotFoundException {
        List<FileData> dataObjectsFromFile = reader.parseFile(WORKING_FILE,
                "Day", "MxT", "MnT");
        assertEquals(30, dataObjectsFromFile.size());
        //file: 1,88,59, ... first line
        assertEquals(dataObjectsFromFile.get(0).getQualifier(), "1");
        assertEquals(dataObjectsFromFile.get(0).getComparator1(), 88);
        assertEquals(dataObjectsFromFile.get(0).getComparator2(), 59);
        //file: 30,90,45,6, ... last line
        assertEquals(dataObjectsFromFile.get(29).getQualifier(), "30");
        assertEquals(dataObjectsFromFile.get(29).getComparator1(), 90);
        assertEquals(dataObjectsFromFile.get(29).getComparator2(), 45);
    }

    @Test
    public void parseCSVFileFileNotFound() throws IdentifierNotFoundException {
        try {
            reader.parseFile(NO_FILE, "Day", "MxT", "MnT");
            fail("Expected an FileException to be thrown");
        } catch (FileException exception) {
            String expectedMessage = String.format(FILE_NOT_FOUND_EXCEPTION, NO_FILE);
            assertEquals(expectedMessage, exception.getMessage());
        }
    }

    @Test
    public void parseCSVFileIdentifierNotFound() throws FileException {
        try {
            reader.parseFile(WORKING_FILE, "Does", "NOT", "Exist");
            fail("Excepted an IdentifierNotFoundException to be thrown");
        } catch (IdentifierNotFoundException exception) {
            String expectedMessage = String.format(IDENTIFIER_NOT_FOUND_EXCEPTION, "Does", "NOT", "Exist");
            assertEquals(expectedMessage, exception.getMessage());
        }
    }
}
