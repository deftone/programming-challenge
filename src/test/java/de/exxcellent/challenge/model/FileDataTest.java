package de.exxcellent.challenge.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by deftone on 14.07.18.
 */
public class FileDataTest {

    private List<FileData> datalist;

    @Before
    public void setUp() {
        FileData data1 = new FileData("eins", 100, 30);
        FileData data2 = new FileData("zwei", 10, 330);
        FileData data3 = new FileData("drei", 10, 12);
        datalist = new ArrayList<>();
        datalist.add(data1);
        datalist.add(data2);
        datalist.add(data3);
    }

    @Test
    public void sortingSuccess() {
        Collections.sort(datalist);
        assertEquals("drei", datalist.get(0).getQualifier());
    }
}
