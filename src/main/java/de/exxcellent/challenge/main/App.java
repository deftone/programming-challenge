package de.exxcellent.challenge.main;

import de.exxcellent.challenge.file.CSVFileReader;
import de.exxcellent.challenge.math.MathUtils;
import de.exxcellent.challenge.model.WeatherData;

import java.util.ArrayList;

/**
 * Created by deftone on 04.07.18.
 */
public class App {

    //todo: use relative path so it will work on other laptops aswell! but relative path does not work :(
    //private final static String FILE_WEATHER = "de/exxcellent/challenge/weather.csv";
    private final static String FILE_WEATHER = "/home/deftone/JAVA/programming-challenge/src/main/resources/de/exxcellent/challenge/weather.csv";
    private final static String FILE_FOOTBALL = "/home/deftone/JAVA/programming-chall11enge/src/main/resources/de/exxcellent/challenge/football.csv";
    private final static String CSV_SEPERATOR = ",";

    public static void main(String... args) {

        //Read data from the file
        CSVFileReader reader = new CSVFileReader();
        ArrayList<WeatherData> weatherDataList = reader.parseCsvFile(FILE_WEATHER, CSV_SEPERATOR,
                "Day", "MxT", "MnT");

        //Determine day with lowest and highest temperature difference
        String dayWithSmallestTempSpread = String.valueOf(MathUtils.findLowestDiff(weatherDataList));
        String dayWithBiggestTempSpread = String.valueOf(MathUtils.findHighestDiff(weatherDataList));

        //Determine best team
        String teamWithSmallesGoalSpread = "A good team"; // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Day with biggest temperature spread  : %s%n", dayWithBiggestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}



