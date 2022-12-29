package Day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Day4 {
    public static void main(String[] args) {
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
        System.out.println(inputList);
        for (String s : inputList) {
            System.out.println(s);
        }
    }
}
