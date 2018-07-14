package de.exxcellent.challenge.model;

/**
 * Data model class for storing the important information of the files into data model objects.
 * Objects of fileData will be stored in Lists.
 */
public class FileData implements Comparable<FileData> {

    private String qualifier;
    private int comparator1;
    private int comparator2;

    /**
     * constructor for filling the file information into data model objects
     *
     * @param qualifier   characterises the relevant information of that file (e.g. day of month or name of soccer team)
     * @param comparator1 first value that gets compared for that qualifier (e.g. maximnum temperature or scored goals)
     * @param comparator2 second value that gets compared for that qualifier (e.g. minimum temperature or allowed goals)
     **/
    public FileData(String qualifier, int comparator1, int comparator2) {
        this.qualifier = qualifier;
        this.comparator1 = comparator1;
        this.comparator2 = comparator2;
    }

    public String getQualifier() {
        return qualifier;
    }

    public int getComparator1() {
        return this.comparator1;
    }

    public int getComparator2() {
        return this.comparator2;
    }

    @Override
    public int compareTo(FileData fileData) {
        //todo: add null check? there should never be a null due to good code before :)
        int absoluteDiffThis = Math.abs(this.comparator1 - this.comparator2);
        int absoluteDiffOther = Math.abs(fileData.comparator1 - fileData.comparator2);
        if (absoluteDiffThis < absoluteDiffOther)
            return -1;
        if (absoluteDiffThis > absoluteDiffOther)
            return 1;
        return 0;
    }
}
