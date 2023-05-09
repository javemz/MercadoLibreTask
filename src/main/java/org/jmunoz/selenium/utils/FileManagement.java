package org.jmunoz.selenium.utils;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class FileManagement {

    public static void WriteAList(String nameFile, List<List<String>> body) {

        try {

             CSVWriter writer = new CSVWriter(new FileWriter("src/test/results/"+nameFile + "Results_" + UUID.randomUUID()+ ".csv"));

                for (List<String> line: body) {
                    String[] arr = new String [line.size()];
                    line.toArray(arr);
                    writer.writeAll(Collections.singleton(arr), true);
                }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}