package de.exxcellent.challenge.math;

import de.exxcellent.challenge.model.FileData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by deftone on 04.07.18.
 */
public class MathUtilsTest {
    private ArrayList<FileData> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(new FileData(0, "1", 25, 15));
        list.add(new FileData(1, "2", 23, 24));
        list.add(new FileData(2, "3", 20, 5));
        list.add(new FileData(3, "4", 35, 30));
    }

    @Test
    public void findLowestDiff() {
        assertEquals("2", MathUtils.getQualifierWithLowestDiff(list));
    }

    @Test
    public void findLowestDiff_nullCheck() {
        assertEquals("", MathUtils.getQualifierWithLowestDiff(null));
    }

    @Test
    public void findLowestDiff_emptyList() {
        assertEquals("", MathUtils.getQualifierWithLowestDiff(new ArrayList<>()));
    }

    @Test
    public void findHighestDiff() {
        assertEquals("3", MathUtils.getQualifierHighestDiff(list));
    }

    @Test
    public void findHighetsDiff_nullCheck() {
        assertEquals("", MathUtils.getQualifierHighestDiff(null));
    }

    @Test
    public void findHighetsDiff_emptyList() {
        assertEquals("", MathUtils.getQualifierHighestDiff(new ArrayList<>()));
    }
}