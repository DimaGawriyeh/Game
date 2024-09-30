package se.company.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputLoader {

    public List<String> loadInputFromFile() {

        List<String> content = new ArrayList<String>();
        BufferedReader textReader = null;

        try {
            FileReader fileReader = new FileReader("src/main/resources/input.txt");
            textReader = new BufferedReader(fileReader);
            String input;
            while (true) {
                input = textReader.readLine();
                if (input != null)
                    content.add(input);
                else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (textReader != null)
                    textReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return content;
    }

}
