package com.epam.automation.inputoutput.optionaltask;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Ввести из текстового файла, связанного с входным потоком, последовательность строк.
//         Выбрать и сохранить m последних слов в каждой из по-следних n строк.
public class Task11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lastWords;
        int lastLines;

        do {
            System.out.println("Введите необходимое количество последних слов из строк");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести положительное целое число");
                sc.next();
            }
            lastWords = Math.abs(sc.nextInt());
        } while (lastWords == 0);

        do {
            System.out.println("Введите необходимое последних строк");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести целое число");
                sc.next();
            }
            lastLines = Math.abs(sc.nextInt());
        } while (lastLines == 0);

        sc.close();



        File fileInput = new File("./src/main/java/com/epam/" +
                "automation/inputoutput/optionaltask/resources/InputLinesForTask11.txt");
        File fileOutput = new File("./src/main/java/com/epam/" +
                "automation/inputoutput/optionaltask/resources/OutputLinesForTask11.txt");
        ArrayList<ArrayList<String>> lines = new ArrayList<>();



        try (Scanner scanner = new Scanner(fileInput)) {
            while (scanner.hasNextLine()) {
                lines.add(new ArrayList<String>(Arrays.asList(scanner.nextLine().split(" "))));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = lines.size() - lastLines; i < lines.size(); i++) {
            if (i>=0 && i<lines.size())

                for (int j = lines.get(i).size() - lastWords; j < lines.get(i).size(); j++) {
                if (j>=0 && j<lines.get(i).size()) {
                    stringBuilder.append(lines.get(i).get(j) + " ");
                }
            }
            stringBuilder.append("\n");
        }



        try (FileWriter writer = new FileWriter(fileOutput)) {
            writer.write(stringBuilder.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
