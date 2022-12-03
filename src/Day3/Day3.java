package Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Day3 {
    //https://adventofcode.com/2022/day/3
    public static void main(String[] args) {
        LinkedList<String> inputList = new LinkedList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/Day3/Input"));
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
        System.out.println(inputList);

        int priority = 0;

        for (String s : inputList) {
            int stringSize = s.length();
            String compartment1 = s.substring(0, stringSize / 2);
            String compartment2 = s.substring(stringSize / 2);
            String letter = checkCompartments(compartment1, compartment2);
            if (!isStringLowerCase(letter)) {
                letter = letter.toLowerCase();
                priority += 26;
            }
            priority += givePriority(letter);
        }
        System.out.println("sum of priority: " + priority);

        int priority2 = 0;
        for (int i = 0; i < inputList.size(); i += 3) {
            String badge = checkGroupRucksacksBadge(inputList.get(i), inputList.get(i + 1), inputList.get(i + 2));
            if (!isStringLowerCase(badge)) {
                badge = badge.toLowerCase();
                priority2 += 26;
            }
            priority2 += givePriority(badge);
        }
        System.out.println("sum of priority2: " + priority2);
    }

    private static String checkGroupRucksacksBadge(String rugSack1, String rugSack2, String rugSack3) {
        String returnString = "";
        for (int i = 0; i < rugSack1.length(); i++) {
            char c = rugSack1.charAt(i);
            if (rugSack2.indexOf(c) != -1 && rugSack3.indexOf(c) != -1) {
                return returnString + c;
            }
        }
        return returnString;
    }

    private static String checkCompartments(String compartment1, String compartment2) {
        String returnString = "";
        for (int i = 0; i < compartment1.length(); i++) {
            char c = compartment1.charAt(i);
            if (compartment2.indexOf(c) != -1) {
                return returnString + c;
            }
        }
        return returnString;
    }

    private static boolean isStringLowerCase(String str) {

        //convert String to char array
        char[] charArray = str.toCharArray();

        for (char c : charArray) {
            //if any character is not in lower case, return false
            if (!Character.isLowerCase(c))
                return false;
        }
        return true;
    }

    private static int givePriority(String s) {
        if (s.equals("a"))
            return 1;
        if (s.equals("b"))
            return 2;
        if (s.equals("c"))
            return 3;
        if (s.equals("d"))
            return 4;
        if (s.equals("e"))
            return 5;
        if (s.equals("f"))
            return 6;
        if (s.equals("g"))
            return 7;
        if (s.equals("h"))
            return 8;
        if (s.equals("i"))
            return 9;
        if (s.equals("j"))
            return 10;
        if (s.equals("k"))
            return 11;
        if (s.equals("l"))
            return 12;
        if (s.equals("m"))
            return 13;
        if (s.equals("n"))
            return 14;
        if (s.equals("o"))
            return 15;
        if (s.equals("p"))
            return 16;
        if (s.equals("q"))
            return 17;
        if (s.equals("r"))
            return 18;
        if (s.equals("s"))
            return 19;
        if (s.equals("t"))
            return 20;
        if (s.equals("u"))
            return 21;
        if (s.equals("v"))
            return 22;
        if (s.equals("w"))
            return 23;
        if (s.equals("x"))
            return 24;
        if (s.equals("y"))
            return 25;
        if (s.equals("z"))
            return 26;
        return 0;
    }
}
