package de.exxcellent.challenge.file;

import de.exxcellent.challenge.model.FileData;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by deftone on 05.07.18.
 */
public class CSVFileReaderTest {

    private final static String WORKING_FILE = "/home/deftone/JAVA/programming-challenge/src/main/resources/de/exxcellent/challenge/weather.csv";
    private final static String CSV_SEPERATOR = ",";

    private final static String one = "one";
    private final static String two = "two";
    private final static String three = "three";
    private final static String four = "four";
    private final static String five = "five";
    private final static String[] dataItems = {one, two, three, four, five};
    private CSVFileReader reader;

    @Before
    public void setUp() {
        reader = new CSVFileReader();
    }

    @Test
    public void determineIndicesSuccess() {
        assertEquals(true, reader.determineIndices(dataItems, one, five, three));
        assertEquals(4, reader.getIndexComparator1());
    }

    @Test
    public void determineIndicesFailure() {
        assertEquals(false, reader.determineIndices(dataItems, "xxx", two, four));
        assertEquals(1, reader.getIndexComparator1());
    }

    @Test
    public void parseCSVFileSuccess() {
        List<FileData> dataObjectsFromFile = reader.parseCsvFile(WORKING_FILE, CSV_SEPERATOR,
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

}
