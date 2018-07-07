package de.exxcellent.challenge.math;

import de.exxcellent.challenge.model.FileData;

import java.util.List;

/**
 * This class contains static functions to evaluate the data read from the file.
 * For now, just largest and lowest absolute difference of two comparator values, but could be more in the future :)
 */
public class MathUtils {

    /**
     * This method calculates the lowest absolute difference between the two comparator values.
     *
     * @param list  this list contains all data objects read from the file (i.e. a list of qualifiers and comparator values)
     * @return      the qualifier that has the lowest absolute difference between the comparators (e.g. the day with the lowest temperature spread)
     **/
    public static String getQualifierWithLowestDiff(List<FileData> list) {
        if (list != null && list.size() > 0) {
            int lowestDiff = Integer.MAX_VALUE;
            int newDiff, index = -1;

            for (FileData data : list) {
                newDiff = Math.abs(data.getComparator1() - data.getComparator2());
                if (newDiff < lowestDiff) {
                    lowestDiff = newDiff;
                    index = data.getId();
                }
            }
            return list.get(index).getQualifier();
        }
        return "";
    }

    /**
     * This method calculates the largest absolute difference between the two comparator values.
     *
     * @param list  this list contains all data objects read from the file (i.e. a list of qualifiers and comparator values)
     * @return      the qualifier that has the largest absolute difference between the comparators
     *              (e.g. the team with the largest goal spread (i.e. very good or very bad team))
     **/
    public static String getQualifierLargestDiff(List<FileData> list) {
        if (list != null && list.size() > 0) {
            int highestDiff = 0;
            int newDiff, index = -1;

            for (FileData data : list) {
                newDiff = Math.abs(data.getComparator1() - data.getComparator2());
                if (newDiff > highestDiff) {
                    highestDiff = newDiff;
                    index = data.getId();
                }
            }
            return list.get(index).getQualifier();
        }
        return "";
    }
}
