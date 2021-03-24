package com.codecool.chessopen;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName) {

        File file = new File(fileName);
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> container = new HashMap();
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] temp = line.split(",");
                String competitorName = temp[0];
                int points = ((Integer.parseInt(temp[1]) +Integer.parseInt(temp[2]) + Integer.parseInt(temp[3]) +Integer.parseInt(temp[4]) +Integer.parseInt(temp[5])));
                container.put(competitorName, points);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        container.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEachOrdered(stringIntegerEntry -> result.add(stringIntegerEntry.getKey()));
        return result;
    }
}
