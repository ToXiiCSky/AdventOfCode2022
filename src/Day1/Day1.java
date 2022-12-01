package Day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Day1 {
    //https://adventofcode.com/2022/day/1
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/Day1/Input"));
            String line = reader.readLine();
            while (line != null) {
                Integer inputInteger = null;
                if (!line.isEmpty()) {
                    inputInteger = Integer.valueOf(line);
                }
                inputList.add(inputInteger);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Top 3 elves: " + getTop3Elves(getAllElves(inputList)));
    }

    public static LinkedList<Integer> getAllElves(LinkedList<Integer> inputList) {
        int currentElf = 0;
        int biggestNumber = 0;
        LinkedList<Integer> elves = new LinkedList<>();

        for (Integer integer : inputList) {
            if (integer != null) {
                currentElf += integer;
            }
            if (integer == null) {
                if (currentElf > biggestNumber) {
                    biggestNumber = currentElf;
                }
                elves.add(currentElf);
                currentElf = 0;
            }
        }
        System.out.println("Meeste calorien: " + biggestNumber);
        return elves;
    }

    public static LinkedList<Integer> getTop3Elves(LinkedList<Integer> inputList) {
        LinkedList<Integer> returnList = new LinkedList<>();
        int biggestNumber = 0;

        while (returnList.size() < 3) {
            for (Integer integer : inputList) {
                if (integer > biggestNumber) {
                    biggestNumber = integer;
                }
            }
            returnList.add(biggestNumber);
            inputList.remove((Integer) biggestNumber);
            biggestNumber = 0;
        }
        int top3calorien = 0;

        for (Integer integer : returnList) {
            top3calorien += integer;
        }
        System.out.println("top 3 samen: " + top3calorien);
        return returnList;
    }
}
