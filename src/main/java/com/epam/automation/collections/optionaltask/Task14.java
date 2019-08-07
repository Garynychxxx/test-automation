package com.epam.automation.collections.optionaltask;

import java.io.File;
import java.io.IOException;
import java.util.*;

//Ввести строки из файла, записать в список ArrayList.
//        Выполнить сортировку строк, используя метод sort() из класса Collections.

public class Task14 {
    public static void main(String[] args) {
        File file = new File("./src/main/java/com/epam/" +
                "automation/collections/optionaltask/resources/LinesForTask14.txt");
        ArrayList<String> lineFromFile = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                lineFromFile.add(scanner.nextLine());
            }

        }catch (IOException ex){
            System.out.println(ex);
        }
        Collections.sort(lineFromFile);
        System.out.println(lineFromFile.toString());

    }
}
