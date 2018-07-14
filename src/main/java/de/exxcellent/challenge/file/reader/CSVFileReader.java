package de.exxcellent.challenge.file.reader;

import de.exxcellent.challenge.file.exceptions.FileException;
import de.exxcellent.challenge.file.exceptions.IdentifierNotFoundException;
import de.exxcellent.challenge.model.FileData;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static de.exxcellent.challenge.model.Constants.CSV_SEPERATOR;
import static de.exxcellent.challenge.model.Constants.FILE_NOT_FOUND_EXCEPTION;
import static de.exxcellent.challenge.model.Constants.IDENTIFIER_NOT_FOUND_EXCEPTION;

/**
 * CSVFileReader implements the interface IFileReader for reading and parsing csv files.
 */
public class CSVFileReader implements IFileReader {
    private int indexQualifier;
    private int indexComparator1;
    private int indexComparator2;

    /**
     * This method reads a csv file and parses the content of that file for the vales of the desired paramters.
     * If the file can not be read (found/opened) an exception is thrown.
     * If the desired parameters can not be found in the first line of the file content, an exception is thrown.
     *
     * @param fileName    name of that file
     * @param qualifier   name of qualifier (first desired parameter, e.g. "team")
     * @param comparator1 name of first comparator (second desired parameter, e.g. "goals")
     * @param comparator2 name of second comparator (third desired parameter, e.g. "goals allowed")
     * @return an array list that contains objects of the values of these desired parameters
     **/
    @Override
    public List<FileData> parseFile(final String fileName, final String qualifier, final String comparator1,
                                    final String comparator2) throws FileException, IdentifierNotFoundException {
        List<FileData> dataObjectsFromFile = new ArrayList<>();

        File file = new File(fileName);
        if (!file.canRead() || !file.isFile() || !file.exists()) {
            throw new FileException(String.format(FILE_NOT_FOUND_EXCEPTION, fileName));
        }

        try (Scanner scanner = new Scanner(file)){
            // initialize the string delimiter
            scanner.useDelimiter(System.lineSeparator());
            //first line: get the index of the properties we want to know
            String[] dataItems = scanner.next().split(CSV_SEPERATOR);
            if (!determineIndices(dataItems, qualifier, comparator1, comparator2)) {
                String message = String.format(IDENTIFIER_NOT_FOUND_EXCEPTION, qualifier,
                        comparator1, comparator2);
                throw new IdentifierNotFoundException(message);
            }
            //if successful: add all data into list of data objects
            while (scanner.hasNext()) {
                dataItems = scanner.next().split(CSV_SEPERATOR);
                dataObjectsFromFile.add(new FileData(dataItems[indexQualifier],
                        Integer.parseInt(dataItems[indexComparator1]),
                        Integer.parseInt(dataItems[indexComparator2])));
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unexpected IO Exception.");
        }
        return dataObjectsFromFile;
    }

    /**
     * This method determines the indices of the desired parameters in the first line of the file content.
     * All three must be found to guarantee correct behaviour later on.
     * Attention: case sensitive!
     *
     * @param dataItems   array of Strings contained in the first line of the file
     * @param qualifier   first desired parameter
     * @param comparator1 second desired parameter
     * @param comparator2 third desired parameter
     * @return true if all three parameters are found - otherwise false
     **/
    boolean determineIndices(String[] dataItems, String qualifier, String comparator1, String comparator2) {
        List<String> dataItemList = Arrays.asList(dataItems);
        indexQualifier = dataItemList.indexOf(qualifier);
        indexComparator1 = dataItemList.indexOf(comparator1);
        indexComparator2 = dataItemList.indexOf(comparator2);
        //all 3 must be found!
        return (indexQualifier != -1 && indexComparator1 != -1 && indexComparator2 != -1);
    }

    //for testing purpose only
    int getIndexComparator1() {
        return this.indexComparator1;
    }

}
