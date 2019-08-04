package com.epam.automation.collections.maintask;

//В кругу стоят N человек, пронумерованных от 1 до N. При ведении счета по кругу вычеркивается каждый второй человек,
//        пока не останется один. Составить две программы,  моделирующие процесс. Одна из программ должна использовать
//        класс ArrayList, а вторая — LinkedList. Какая из двух программ работает быстрее? Почему?

import java.util.*;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queueLength;

        do {
            System.out.println("Введите необходимое длинну очереди");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести положительное целое число");
                sc.next();
            }
            queueLength = sc.nextInt();
        } while (queueLength <= 0);

        ArrayList<String> arrayList = new ArrayList<String>(Collections.nCopies(queueLength, "Person"));
        System.out.println(getTimeToRemoveEverySecondOfArrayList(arrayList) > getTimeToRemoveEverySecondOfLinkedLIst(arrayList)
                ? "Как и ожидалось LinkedList с данной задачей справляется быстрей," +
                "\n т.к. для удаления элемента достаточно поменять ссылки его соседей," +
                "\n а для ArrayList необходимо \"пробежать\" весь список целиком"
                : "Недостаточное количество элементов для видимости результата.");

    }

    static Long getTimeToRemoveEverySecondOfArrayList(ArrayList<String> arrayList) {
        ArrayList<String> changedArray = new ArrayList<>(arrayList);
        Date startArray = new Date();
        while (changedArray.size() > 1) {

            Iterator iterator = changedArray.iterator();
            for (int i = 0; iterator.hasNext(); i++, iterator.next()) {
                if (i % 2 == 1) {
                    i = 0;
                    iterator.remove();
                }
            }
        }

        Date finishArray = new Date();
        return finishArray.getTime() - startArray.getTime();
    }


    static Long getTimeToRemoveEverySecondOfLinkedLIst(ArrayList<String> arrayList) {

        LinkedList<String> linkedList = new LinkedList<>(arrayList);

        Date startLinked = new Date();
        while (linkedList.size() > 1) {
            Iterator iterator = linkedList.iterator();
            for (int i = 0; iterator.hasNext(); i++, iterator.next()) {
                if (i % 2 == 1) {
                    i = 0;
                    iterator.remove();
                }
            }
        }
        Date finishLinked = new Date();
        return finishLinked.getTime() - startLinked.getTime();
    }
}
