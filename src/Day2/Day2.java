package Day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Day2 {
    //https://adventofcode.com/2022/day/2
    public static void main(String[] args) {
        LinkedList<String> inputList = new LinkedList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "src/Day2/Input"));
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

        /* A,X = rock 1 point
         * B,Y = Paper 2 points
         * C,Z = Scissors 3 points */

        int score = 0;
        for (String s : inputList) {
            if (s.contains("A")) {
                System.out.println("opponent plays Rock");
                if (s.contains("X")) {
                    System.out.println("play: rock +1 point");
                    System.out.println("draw: +3 points");
                    score += 3; // draw points
                    score += 1; // rock points
                } else if (s.contains("Y")) {
                    System.out.println("play: paper +2 points");
                    System.out.println("win: + 6 points");
                    score += 6; // win points
                    score += 2; // paper points
                } else {
                    System.out.println("play: scissors +3 points");
                    System.out.println("lose: 0 points");
                    score += 3; // scissor points
                }
            } else if (s.contains("B")) {
                System.out.println("opponent plays Paper");
                if (s.contains("Y")) {
                    System.out.println("play: paper +2 point");
                    System.out.println("draw: +3 points");
                    score += 3; // draw points
                    score += 2; // paper points
                } else if (s.contains("Z")) {
                    System.out.println("play: scissors +3 points");
                    System.out.println("win: + 6 points");
                    score += 6; // win points
                    score += 3; // scissor points
                } else {
                    System.out.println("play: rock +1 points");
                    System.out.println("lose: 0 points");
                    score++; // rock points
                }
            } else if (s.contains("C")) {
                System.out.println("opponent plays Scissors");
                if (s.contains("X")) {
                    System.out.println("play: rock +1 points");
                    System.out.println("win: + 6 points");
                    score += 6; // win points
                    score += 1; // rock points
                } else if (s.contains("Z")) {
                    System.out.println("play: scissors +3 point");
                    System.out.println("draw: +3 points");
                    score += 3; // draw points
                    score += 3; // scissor points
                } else {
                    System.out.println("play: paper +2 points");
                    System.out.println("lose: 0 points");
                    score += 2; // paper points
                }
            }
            System.out.println("------------------------------");
        }
        System.out.println("End score: " + score);

        /* A = rock 1 point
         * B = Paper 2 points
         * C = Scissors 3 points
         * X = We lose
         * Y = We draw
         * Z = we win */

        score = 0;
        for (String s : inputList) {
            if (s.contains("A")) {
                System.out.println("opponent plays Rock");
                if (s.contains("X")) {
                    System.out.println("play: scissors +3 points");
                    System.out.println("lose: 0 points");
                    score += 3; // scissor points
                } else if (s.contains("Y")) {
                    System.out.println("play: rock +1 point");
                    System.out.println("draw: +3 points");
                    score += 3; // draw points
                    score += 1; // rock points
                } else if (s.contains("Z")) {
                    System.out.println("play: paper +2 points");
                    System.out.println("win: + 6 points");
                    score += 6; // win points
                    score += 2; // paper points
                }
            } else if (s.contains("B")) {
                System.out.println("opponent plays Paper");
                if (s.contains("X")) {
                    System.out.println("play: rock +1 points");
                    System.out.println("lose: 0 points");
                    score += 1; // rock points
                } else if (s.contains("Y")) {
                    System.out.println("play: paper +2 point");
                    System.out.println("draw: +3 points");
                    score += 3; // draw points
                    score += 2; // paper points
                } else if (s.contains("Z")) {
                    System.out.println("play: scissors +3 points");
                    System.out.println("win: + 6 points");
                    score += 6; // win points
                    score += 3; // scissor points
                }
            } else if (s.contains("C")) {
                System.out.println("opponent plays Scissors");
                if (s.contains("X")) {
                    System.out.println("play: paper +2 points");
                    System.out.println("lose: 0 points");
                    score += 2; // paper points
                } else if (s.contains("Y")) {
                    System.out.println("play: scissor +3 point");
                    System.out.println("draw: +3 points");
                    score += 3; // draw points
                    score += 3; // scissor points
                } else if (s.contains("Z")) {
                    System.out.println("play: rock +1 points");
                    System.out.println("win: + 6 points");
                    score += 6; // win points
                    score += 1; // rock points
                }
            }
            System.out.println("------------------------------");
        }
        System.out.println("End score: " + score);
    }
}
