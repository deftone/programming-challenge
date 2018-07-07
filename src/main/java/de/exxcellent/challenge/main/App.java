package de.exxcellent.challenge.main;

import de.exxcellent.challenge.file.FileReaderFactory;
import de.exxcellent.challenge.file.exceptions.FileException;
import de.exxcellent.challenge.file.exceptions.FileTypeNotSupportedException;
import de.exxcellent.challenge.file.exceptions.IdentifierNotFoundException;
import de.exxcellent.challenge.file.reader.IFileReader;
import de.exxcellent.challenge.math.MathUtils;
import de.exxcellent.challenge.model.FileData;

import java.util.List;

/**
 * main method for starting the challenge programming app
 * **/
public class App {
    private final static String FILE_WEATHER = "src/main/resources/de/exxcellent/challenge/weather.csv";
    private final static String FILE_FOOTBALL = "src/main/resources/de/exxcellent/challenge/football.csv";

    public static void main(String... args) {
        //get correct filereader depending on datafile (csv, json)
        FileReaderFactory fileReaderFactory = new FileReaderFactory();

        /** Weather Challenge **/
        try {
            //Read data from the file
            IFileReader reader = fileReaderFactory.getFileReader(FILE_WEATHER);

            List<FileData> weatherDataList = reader.parseFile(FILE_WEATHER,
                    "Day", "MxT", "MnT");

            //Determine day with lowest and highest temperature difference
            String dayWithSmallestTempSpread = MathUtils.getQualifierWithLowestDiff(weatherDataList);
            String dayWithBiggestTempSpread = MathUtils.getQualifierLargestDiff(weatherDataList);

            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            System.out.printf("Day with biggest  temperature spread : %s%n", dayWithBiggestTempSpread);

        } catch (FileException | IdentifierNotFoundException | FileTypeNotSupportedException e) {
            e.printStackTrace();
        }


        /** Football Challenge **/
        try {
            //Read data from the file
            IFileReader reader = fileReaderFactory.getFileReader(FILE_FOOTBALL);

            List<FileData> footballDataList = reader.parseFile(FILE_FOOTBALL,
                    "Team", "Goals", "Goals Allowed");
            //Determine best and worst (?) team
            String teamWithSmallestGoalSpread = MathUtils.getQualifierWithLowestDiff(footballDataList);
            String teamWithBiggestGoalSpread = MathUtils.getQualifierLargestDiff(footballDataList);

            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
            System.out.printf("Team with biggest  goal spread       : %s%n", teamWithBiggestGoalSpread);
        } catch (FileException | IdentifierNotFoundException | FileTypeNotSupportedException e) {
            e.printStackTrace();
        }
    }
}



