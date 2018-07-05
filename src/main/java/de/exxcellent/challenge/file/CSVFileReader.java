package de.exxcellent.challenge.file;

import de.exxcellent.challenge.model.WeatherData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by deftone on 04.07.18.
 * <p>
 * reads a csv file and returns a list of data objects
 */
public class CSVFileReader {
    private int indexCriterion;
    private int indexMax;
    private int indexMin;

    public ArrayList<WeatherData> parseCsvFile(final String fileName, final String separator,
                                          final String criterion, final String max, final String min) {
        ArrayList<WeatherData> dataObjectsFromFile = new ArrayList<>();

        //read file
        File file = new File(fileName);
        if (!file.canRead() || !file.isFile()) {
            System.out.println("File '" + fileName + "' can not be accessed. Exit programming challenge.");
            System.exit(0);
        }

        //use buffered reader to get access to file content
        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataItems = line.split(separator);

                //first get the index of the properties we want to know
                if (i == 0) {
                    //if parameters are not found, exit program
                    if (!determineIndices(dataItems, criterion, max, min)) {
                        System.out.println("At least one parameter (" + criterion + ", "
                                + max + ", " + min + ") not found. Exit programming challenge.");
                        System.exit(0);
                    }
                } else {
                    dataObjectsFromFile.add(new WeatherData(Integer.parseInt(dataItems[indexCriterion]),
                            Integer.parseInt(dataItems[indexMax]),
                            Integer.parseInt(dataItems[indexMin])));
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unexpected IO Exception. Exit programming challenge.");
            System.exit(0);
        } finally {
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Can not close bufferedReader");
                }
        }
        return dataObjectsFromFile;
    }

    boolean determineIndices(String[] dataItems, String criterion, String max, String min) {
        int check = 0;
        for (int i = 0; i < dataItems.length; i++) {
            if (dataItems[i].equals(criterion)) {
                indexCriterion = i;
                check++;
            }
            if (dataItems[i].equals(max)) {
                indexMax = i;
                check++;
            }
            if (dataItems[i].equals(min)) {
                indexMin = i;
                check++;
            }
        }
        //all three parameters must be found! otherwise, no guarantee for correct values later
        if (check == 3) {
            return true;
        } else {
            return false;
        }
    }

    //for testing purpose only
    int getIndexMax() {
        return this.indexMax;
    }

}
