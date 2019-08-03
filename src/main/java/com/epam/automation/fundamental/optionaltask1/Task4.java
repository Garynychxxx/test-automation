package com.epam.automation.fundamental.optionaltask1;

//Ввести целые числа как аргументы командной строки,
// подсчитать их сумму (произведение) и вывести результат на консоль.

public class Task4 {

    public static void main(String[] args) {

        int summOfCommandLine = 0;
        int multiplOfCommandLine = 0;

        for (String arg : args) {
            summOfCommandLine += Integer.parseInt(arg);
            multiplOfCommandLine *= Integer.parseInt(arg);
        }

        System.out.println("Сумма оргументов командной строки: " + summOfCommandLine + "," +
                            " а произведение: " + multiplOfCommandLine);

    }

}

