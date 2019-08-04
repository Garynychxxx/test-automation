package com.epam.automation.collections.optionaltask;

import java.io.File;
import java.io.IOException;
import java.util.*;

//Задан файл с текстом на английском языке. Выделить все различные слова.
//        Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.

public class Task16 {
    public static void main(String[] args) {
        File file = new File("./src/main/java/com/epam/" +
                "automation/collections/optionaltask/resources/EnglishTextForTask16.txt");
        Set<String> stringSet = new HashSet<>();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                stringSet.addAll(Arrays.asList(scanner.nextLine()
                        .toLowerCase().split("[^a-z]")));
            }
            stringSet.remove("");
        }catch (IOException ex){
            System.out.println(ex);
        }
        System.out.println(stringSet.toString());

    }
}


