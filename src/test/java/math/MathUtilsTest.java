package math;

import model.WeatherData;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by deftone on 04.07.18.
 */
public class MathUtilsTest {
    private ArrayList<WeatherData> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<>();
        list.add(new WeatherData(1, 25, 15));
        list.add(new WeatherData(2, 25, 14));
        list.add(new WeatherData(3, 20, 5));
        list.add(new WeatherData(4, 35, 30));
    }

    @Test
    public void findLowestDiff(){
        assertEquals(4, MathUtils.findLowestDiff(list));
    }

    @Test
    public void findLowestDiff_nullCheck(){
        assertEquals(-1, MathUtils.findLowestDiff(null));
    }

    @Test
    public void findLowestDiff_emptyList(){
        assertEquals(-1, MathUtils.findLowestDiff(new ArrayList<>()));
    }

    @Test
    public void findHighestDiff(){
        assertEquals(3, MathUtils.findHighestDiff(list));
    }

    @Test
    public void findHighetsDiff_nullCheck(){
        assertEquals(-1, MathUtils.findHighestDiff(null));
    }

    @Test
    public void findHighetsDiff_emptyList(){
        assertEquals(-1, MathUtils.findHighestDiff(new ArrayList<>()));
    }
}