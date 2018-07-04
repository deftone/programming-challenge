package de.exxcellent.challenge.math;

import de.exxcellent.challenge.model.WeatherData;

import java.util.ArrayList;

/**
 * Created by deftone on 04.07.18.
 * <p>
 * this class contains static functions to evaluate the data read from the de.exxcellent.challenge.file
 * for now, just highest and lowest difference of these two values, but could be more in the future :)
 */
public class MathUtils {

    public static int findLowestDiff(ArrayList<WeatherData> list) {
        if (list != null && list.size() > 0) {
            int lowestDiff = Integer.MAX_VALUE;
            int newDiff, index = -1;

            for (WeatherData data : list) {
                newDiff = data.getMaxTemperature() - data.getMinTemperature();
                if (newDiff < lowestDiff) {
                    lowestDiff = newDiff;
                    index = data.getDay();
                }
            }
            return index;
        }
        return -1;
    }

    public static int findHighestDiff(ArrayList<WeatherData> list) {
        if (list != null && list.size() > 0) {
            int highestDiff = 0;
            int newDiff, index = -1;

            for (WeatherData data : list) {
                newDiff = data.getMaxTemperature() - data.getMinTemperature();
                if (newDiff > highestDiff) {
                    highestDiff = newDiff;
                    index = data.getDay();
                }
            }
            return index;
        }
        return -1;
    }
}
