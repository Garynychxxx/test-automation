package com.epam.automation.inputoutput.optionaltask;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//[^ |].+(\.[A_Za-z0-9_!~=+-]+)$   (для файла)
//[^ |].*\.(?![A_Za-z0-9_!~=+-]+)$ (для папки)


// Прочитать строки из файла и поменять местами первое и последнее слова в каждой строке.

public class Task10 {
    public static void main(String[] args) {
        File file = new File("./src/main/java/com/epam/" +
                "automation/inputoutput/optionaltask/resources/LinesForTask10.txt");
        ArrayList<ArrayList<String>> lines = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                lines.add(new ArrayList<String>(Arrays.asList(scanner.nextLine().split(" "))));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }


        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<String> words : lines) {
            stringBuilder.append(words.get(words.size() - 1) + " ");
            for (int i = 1; i < words.size() - 1; i++) {
                stringBuilder.append(words.get(i) + " ");
            }
            stringBuilder.append(words.get(0) + "\n");
        }






        try (FileWriter writer = new FileWriter(file)) {
            writer.write(stringBuilder.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }


    }
}

