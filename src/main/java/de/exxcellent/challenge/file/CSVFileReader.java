package de.exxcellent.challenge.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by deftone on 04.07.18.
 */
public class CSVFileReader {
    //we don't want any instances of this class
    private CSVFileReader() {
    }

    public static List<String> readFile(final String fileName, final String separator) {

        File file = new File(fileName);
        List<String> fileContent = new ArrayList<>();

        if (!file.canRead() || !file.isFile()) {
            System.out.println("Übergebene Datei " + fileName + " ist keine Datei oder schreibgeschützt." +
                    "Programm wird abggebrochen.");
            System.exit(0);
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            String zeile;
            while ((zeile = bufferedReader.readLine()) != null) {
                System.out.println("Gelesene Zeile: " + zeile);
                //ganze zeile hinzufuegen, mit kommas (oder was als separator definiert wurde)
                fileContent.add(zeile);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("unerwartete IO Exception, Programm wird beendet.");
            System.exit(0);
        } finally {
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("bufferedReader konnte nicht geschlossen werden!");
                }
        }
        return fileContent;
    }
}
