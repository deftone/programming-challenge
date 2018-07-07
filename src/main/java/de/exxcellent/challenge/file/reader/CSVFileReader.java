package de.exxcellent.challenge.file.reader;

import de.exxcellent.challenge.file.exceptions.FileException;
import de.exxcellent.challenge.file.exceptions.IdentifierNotFoundException;
import de.exxcellent.challenge.model.FileData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVFileReader implements the interface IFileReader for reading and parsing csv files.
 */
public class CSVFileReader implements IFileReader {
    private int indexQualifier;
    private int indexComparator1;
    private int indexComparator2;
    private final static String CSV_SEPERATOR = ",";
    final static String FILE_NOT_FOUND_EXCEPTION = "File '%s' can not be accessed. \nPlease check path and readability";
    final static String IDENTIFIER_NOT_FOUND_EXCEPTION = "At least one of the parameters '%s', '%s' and '%s' was not found.";

    /**
     * This method reads a csv file and parses the content of that file for the vales of the desired paramters.
     * If the file can not be read (found/opened) an exception is thrown.
     * If the desired parameters can not be found in the first line of the file content, an exception is thrown.
     *
     * @param fileName      name of that file
     * @param qualifier     name of qualifier (first desired parameter, e.g. "team")
     * @param comparator1   name of first comparator (second desired parameter, e.g. "goals")
     * @param comparator2   name of second comparator (third desired parameter, e.g. "goals allowed")
     * @return              an array list that contains objects of the values of these desired parameters
     * **/
    @Override
    public List<FileData> parseFile(final String fileName, final String qualifier, final String comparator1,
                                    final String comparator2) throws FileException, IdentifierNotFoundException {
        List<FileData> dataObjectsFromFile = new ArrayList<>();

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
                String[] dataItems = line.split(CSV_SEPERATOR);

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

    /**
     * This method determines the indices of the desired parameters in the first line of the file content.
     * All three must be found to guarantee correct behaviour later on.
     * There are two possibilities: case sensitive or case insensitive comparison. This method implements the latter.
     *
     * @param dataItems     array of Strings contained in the first line of the file
     * @param qualifier     first desired parameter
     * @param comparator1   second desired parameter
     * @param comparator2   third desired parameter
     * @return              true if all three parameters are found - otherwise false
     **/
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
        return (check == 3);
    }

    //for testing purpose only
    int getIndexComparator1() {
        return this.indexComparator1;
    }

}
