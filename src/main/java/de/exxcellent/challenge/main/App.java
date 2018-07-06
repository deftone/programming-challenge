package de.exxcellent.challenge.main;

import de.exxcellent.challenge.file.CSVFileReader;
import de.exxcellent.challenge.math.MathUtils;
import de.exxcellent.challenge.model.FileData;

import java.util.ArrayList;

/**
 * Created by deftone on 04.07.18.
 */
public class App {

    //todo: use relative path so it will work on other laptops aswell! but relative path does not work :(
    //private final static String FILE_WEATHER = "de/exxcellent/challenge/weather.csv";
    private final static String FILE_WEATHER = "/home/deftone/JAVA/programming-challenge/src/main/resources/de/exxcellent/challenge/weather.csv";
    private final static String FILE_FOOTBALL = "/home/deftone/JAVA/programming-challenge/src/main/resources/de/exxcellent/challenge/football.csv";
    private final static String CSV_SEPERATOR = ",";

    public static void main(String... args) {

        /** Weather Challenge **/
        //Read data from the file
        CSVFileReader reader = new CSVFileReader();
        ArrayList<FileData> weatherDataList = reader.parseCsvFile(FILE_WEATHER, CSV_SEPERATOR,
                "Day", "MxT", "MnT");

        //Determine day with lowest and highest temperature difference
        String dayWithSmallestTempSpread = MathUtils.getQualifierWithLowestDiff(weatherDataList);
        String dayWithBiggestTempSpread = MathUtils.getQualifierHighestDiff(weatherDataList);

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Day with biggest  temperature spread : %s%n", dayWithBiggestTempSpread);

        /** Football Challenge **/

        ArrayList<FileData> footballDataList = reader.parseCsvFile(FILE_FOOTBALL, CSV_SEPERATOR,
                "Team", "Goals", "Goals Allowed");

        //Determine best and worst (?) team
        String teamWithSmallestGoalSpread = MathUtils.getQualifierWithLowestDiff(footballDataList);
        String teamWithBiggestGoalSpread = MathUtils.getQualifierHighestDiff(footballDataList);

        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        System.out.printf("Team with biggest  goal spread       : %s%n", teamWithBiggestGoalSpread);
    }
}



