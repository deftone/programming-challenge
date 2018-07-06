package de.exxcellent.challenge.file;

import de.exxcellent.challenge.model.FileData;

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
    private int indexQualifier;
    private int indexComparator1;
    private int indexComparator2;

    public ArrayList<FileData> parseCsvFile(final String fileName, final String separator,
                                            final String qualifier, final String comparator1, final String comparator2) {
        ArrayList<FileData> dataObjectsFromFile = new ArrayList<>();

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
            int i = -1;
            while ((line = bufferedReader.readLine()) != null) {
                String[] dataItems = line.split(separator);

                //first get the index of the properties we want to know
                if (i == -1) {
                    //if parameters are not found, exit program
                    if (!determineIndices(dataItems, qualifier, comparator1, comparator2)) {
                        System.out.println("At least one parameter (" + qualifier + ", "
                                + comparator1 + ", " + comparator2 + ") not found. Exit programming challenge.");
                        System.exit(0);
                    }
                } else {
                    dataObjectsFromFile.add(new FileData(i,
                            dataItems[indexQualifier],
                            Integer.parseInt(dataItems[indexComparator1]),
                            Integer.parseInt(dataItems[indexComparator2])));
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

    boolean determineIndices(String[] dataItems, String qualifier, String comparator1, String comparator2) {
        int check = 0;
        for (int i = 0; i < dataItems.length; i++) {
            if (dataItems[i].equals(qualifier)) {
                indexQualifier = i;
                check++;
            }
            if (dataItems[i].equals(comparator1)) {
                indexComparator1 = i;
                check++;
            }
            if (dataItems[i].equals(comparator2)) {
                indexComparator2 = i;
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
    int getIndexComparator1() {
        return this.indexComparator1;
    }

}
