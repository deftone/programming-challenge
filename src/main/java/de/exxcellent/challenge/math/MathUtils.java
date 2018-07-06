package de.exxcellent.challenge.math;

import de.exxcellent.challenge.model.FileData;

import java.util.ArrayList;

/**
 * Created by deftone on 04.07.18.
 * <p>
 * this class contains static functions to evaluate the data read from the de.exxcellent.challenge.file
 * for now, just highest and lowest difference of these two values, but could be more in the future :)
 */
public class MathUtils {

    public static String getQualifierWithLowestDiff(ArrayList<FileData> list) {
        if (list != null && list.size() > 0) {
            int lowestDiff = Integer.MAX_VALUE;
            int newDiff, index = -1;

            for (FileData data : list) {
                newDiff = data.getComparator1() - data.getComparator2();
                if (newDiff < lowestDiff) {
                    lowestDiff = newDiff;
                    index = data.getId();
                }
            }
            return list.get(index).getQualifier();
        }
        return "";
    }

    public static String getQualifierHighestDiff(ArrayList<FileData> list) {
        if (list != null && list.size() > 0) {
            int highestDiff = 0;
            int newDiff, index = -1;

            for (FileData data : list) {
                newDiff = data.getComparator1() - data.getComparator2();
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
