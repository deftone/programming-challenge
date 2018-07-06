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
    final static String FILE_NOT_FOUND_EXCEPTION = "File '%s' can not be accessed. \n " +
            "Please check path and readability";
    final static String IDENTIFIER_NOT_FOUND_EXCEPTION = "At least one of the parameters '%s', '%s' and '%s' was not found.";

    public ArrayList<FileData> parseCsvFile(final String fileName, final String separator,
                                            final String qualifier, final String comparator1,
                                            final String comparator2) throws FileException, IdentifierNotFoundException {
        ArrayList<FileData> dataObjectsFromFile = new ArrayList<>();

        //read file
        File file = new File(fileName);
        if (!file.canRead() || !file.isFile()) {
            throw new FileException(String.format(FILE_NOT_FOUND_EXCEPTION, fileName));
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
                        String message = String.format(IDENTIFIER_NOT_FOUND_EXCEPTION, qualifier,
                                comparator1, comparator2);
                        throw new IdentifierNotFoundException(message);
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
            System.out.println("Unexpected IO Exception.");
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

    /** there are two possibilities: case sensitive comparison or not. i chose the latter**/
    boolean determineIndices(String[] dataItems, String qualifier, String comparator1, String comparator2) {
        int check = 0;
        for (int i = 0; i < dataItems.length; i++) {
            if (dataItems[i].toLowerCase().equals(qualifier.toLowerCase())) {
                indexQualifier = i;
                check++;
            }
            if (dataItems[i].toLowerCase().equals(comparator1.toLowerCase())) {
                indexComparator1 = i;
                check++;
            }
            if (dataItems[i].toLowerCase().equals(comparator2.toLowerCase())) {
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
