package de.exxcellent.challenge.model;

/**
 * Created by deftone on 04.07.18.
 */
public class FileData {

    private int id;
    private String qualifier;
    private int comparator1;
    private int comparator2;

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
