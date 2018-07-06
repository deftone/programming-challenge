package de.exxcellent.challenge.file;

import static de.exxcellent.challenge.file.FileReaderFactory.FILE_TYPE_NOT_SUPPORTED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import de.exxcellent.challenge.file.exceptions.FileTypeNotSupportedException;
import de.exxcellent.challenge.file.reader.CSVFileReader;
import de.exxcellent.challenge.file.reader.IFileReader;
import de.exxcellent.challenge.file.reader.JSONFileReader;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by deftone on 06.07.18.
 */
public class FileReaderFactoryTest {
    private final static String CSV_FILE = "src/main/resources/de/exxcellent/challenge/weather.csv";
    private final static String JSON_FILE = "src/main/resources/de/exxcellent/challenge/fake.json";
    private final static String TXT_FILE = "src/main/resources/de/exxcellent/challenge/fake.txt";
    private final static String NO_FILE = "src/main/resources/de/exxcellent/challenge/noFileExtension";

    private FileReaderFactory factory;


    @Before
    public void setUp() {
        factory = new FileReaderFactory();
    }

    @Test
    public void getCsvFileReader() throws FileTypeNotSupportedException {
        IFileReader reader = factory.getFileReader(CSV_FILE);
        assertEquals(true, reader instanceof CSVFileReader);
    }

    @Test
    public void getJsonFileReader() throws FileTypeNotSupportedException {
        IFileReader reader = factory.getFileReader(JSON_FILE);
        assertEquals(true, reader instanceof JSONFileReader);
    }

    @Test
    public void fileTypeNotSupported() {
        try {
            factory.getFileReader(TXT_FILE);
            fail("Expected a FileTypeNotSupportedException to be thrown");
        } catch (FileTypeNotSupportedException e) {
            assertEquals(FILE_TYPE_NOT_SUPPORTED, e.getMessage());
        }
    }

    @Test
    public void badFileTypeSupported() {
        try {
            factory.getFileReader(NO_FILE);
            fail("Expected a FileTypeNotSupportedException to be thrown");
        } catch (FileTypeNotSupportedException e) {
            assertEquals(FILE_TYPE_NOT_SUPPORTED, e.getMessage());
        }
    }

}