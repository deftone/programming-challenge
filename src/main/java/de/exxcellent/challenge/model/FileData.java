package de.exxcellent.challenge.model;

/**
 * Data model class for storing the important information of the files into data model objects.
 * Objects of fileData will be stored in Lists.
 */
public class FileData {

    private int id;
    private String qualifier;
    private int comparator1;
    private int comparator2;

    /**
     * constructor for filling the file information into data model objects
     *
     * @param id            unique number to get easy access in mathematical operations on a data object
     * @param qualifier     characterises the relevant information of that file (e.g. day of month or name of soccer team)
     * @param comparator1   first value that gets compared for that qualifier (e.g. maximnum temperature or scored goals)
     * @param comparator2   second value that gets compared for that qualifier (e.g. minimum temperature or allowed goals)
     * **/
    public FileData(int id, String qualifier, int comparator1, int comparator2) {
        this.id = id;
        this.qualifier = qualifier;
        this.comparator1 = comparator1;
        this.comparator2 = comparator2;
    }

    public int getId() {
        return id;
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

}
