package de.exxcellent.challenge.model;

/**
 * Created by deftone on 14.07.18.
 */
public interface Constants {
    String FILE_WEATHER = "src/main/resources/de/exxcellent/challenge/weather.csv";
    String FILE_FOOTBALL = "src/main/resources/de/exxcellent/challenge/football.csv";


    String CSV = "csv";
    String JSON = "json";

    String CSV_SEPERATOR = ",";

    String FILE_TYPE_NOT_SUPPORTED = "Filetype is not supported. File parser exist only for CSV and JSON";
    String FILE_NOT_FOUND_EXCEPTION = "File '%s' can not be accessed. \nPlease check path and readability";
    String IDENTIFIER_NOT_FOUND_EXCEPTION = "At least one of the parameters '%s', '%s' and '%s' was not found.";

}
