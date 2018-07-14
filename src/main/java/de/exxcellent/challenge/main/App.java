package de.exxcellent.challenge.main;

import de.exxcellent.challenge.file.FileReaderFactory;
import de.exxcellent.challenge.file.exceptions.FileException;
import de.exxcellent.challenge.file.exceptions.FileTypeNotSupportedException;
import de.exxcellent.challenge.file.exceptions.IdentifierNotFoundException;
import de.exxcellent.challenge.file.reader.IFileReader;
import de.exxcellent.challenge.model.FileData;

import java.util.Collections;
import java.util.List;

import static de.exxcellent.challenge.model.Constants.FILE_FOOTBALL;
import static de.exxcellent.challenge.model.Constants.FILE_WEATHER;

/**
 * main method for starting the challenge programming app
 **/
public class App {

    public static void main(String... args) {
        //get correct filereader depending on datafile (csv, json)
        FileReaderFactory fileReaderFactory = new FileReaderFactory();

        /** Weather Challenge **/
        try {
            //Read data from the file
            IFileReader reader = fileReaderFactory.getFileReader(FILE_WEATHER);

            List<FileData> weatherDataList = reader.parseFile(FILE_WEATHER,
                    "Day", "MxT", "MnT");

            //now sort list according to implemented Comparable:
            Collections.sort(weatherDataList);

            //Determine day with lowest and highest temperature difference
            String dayWithSmallestTempSpread = weatherDataList.get(0).getQualifier();
            System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);

        } catch (FileException | IdentifierNotFoundException | FileTypeNotSupportedException e) {
            e.printStackTrace();
        }


        /** Football Challenge **/
        try {
            //Read data from the file
            IFileReader reader = fileReaderFactory.getFileReader(FILE_FOOTBALL);

            List<FileData> footballDataList = reader.parseFile(FILE_FOOTBALL,
                    "Team", "Goals", "Goals Allowed");

            //now sort list
            Collections.sort(footballDataList);
            String teamWithSmallestGoalSpread = footballDataList.get(0).getQualifier();

            System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
        } catch (FileException | IdentifierNotFoundException | FileTypeNotSupportedException e) {
            e.printStackTrace();
        }
    }
}



