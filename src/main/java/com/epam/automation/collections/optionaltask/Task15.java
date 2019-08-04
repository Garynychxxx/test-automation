package com.epam.automation.collections.optionaltask;

//Задана строка, состоящая из символов «(», «)», «[», «]», «{», «}». Проверить правильность расстановки скобок. Использовать стек.

import java.util.Stack;

public class Task15 {


    public static boolean isBalanced(String in) {
        Stack<Character> bracketsStackChar = new Stack<Character>();

        for (char bracket : in.toCharArray()) {
            switch (bracket) {

                case '{':
                case '(':
                case '[':
                    bracketsStackChar.push(bracket);
                    break;

                case ']':
                    if (bracketsStackChar.isEmpty() || bracketsStackChar.pop() != '[')
                        return false;
                    break;
                case ')':
                    if (bracketsStackChar.isEmpty() || bracketsStackChar.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (bracketsStackChar.isEmpty() || bracketsStackChar.pop() != '{')
                        return false;
                    break;
            }
        }
        return bracketsStackChar.isEmpty();
    }

    public static void main(String args[]) {

        System.out.println(isBalanced("[](){}"));
        System.out.println(isBalanced("({[]})"));
        System.out.println(isBalanced("{}()[]]"));
        System.out.println(isBalanced("[{}()[]]"));

    }
}
