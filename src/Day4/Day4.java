package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day4 {
    public static void main(String[] args) {
        //https://adventofcode.com/2022/day/4
        LinkedList<String> inputList = new LinkedList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/Day4/Input"));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                inputList.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int counter = 0;
        int counterOverlap = 0;

        for (String s : inputList) {
            // Split the string on the ',' character to get the ranges
            String[] ranges = s.split(",");

            // Create a list to store the integers
            List<Integer> integers = new ArrayList<>();

            // Iterate over the ranges
            for (String range : ranges) {
                // Split the range on the '-' character to get the start and end
                String[] startEnd = range.split("-");
                int start = Integer.parseInt(startEnd[0]);
                int end = Integer.parseInt(startEnd[1]);
                integers.add(start);
                integers.add(end);
            }

            // Print the list of integers
            System.out.println(integers);

            int startTeam1 = integers.get(0);
            int endTeam1 = integers.get(1);
            int startTeam2 = integers.get(2);
            int endTeam2 = integers.get(3);

            if (checkTeams(startTeam1, endTeam1, startTeam2, endTeam2)) {
                counter++;
            }
            if (checkTeamsOverlap(startTeam1, endTeam1, startTeam2, endTeam2)) {
                counterOverlap++;
            }
        }
        System.out.println("counter: " + counter);
        System.out.println("counterOverlap: " + counterOverlap);
    }

    public static boolean checkTeams(int startTeam1, int endTeam1, int startTeam2, int endTeam2) {
        if (startTeam2 >= startTeam1 && endTeam2 <= endTeam1)
            return true;
        return startTeam1 >= startTeam2 && endTeam1 <= endTeam2;
    }

    public static boolean checkTeamsOverlap(int startTeam1, int endTeam1, int startTeam2, int endTeam2) {
        if (checkTeams(startTeam1, endTeam1, startTeam2, endTeam2))
            return true;
        else {
            if (startTeam1 <= startTeam2 && endTeam1 >= startTeam2)
                return true;
            return endTeam2 >= startTeam1 && endTeam2 <= endTeam1;
        }
    }
}
