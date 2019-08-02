package com.epam.automation.fundamental.optionaltask4;

import java.util.Random;
import java.util.Scanner;

//    Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в
//        интервале значений от -M до M с помощью генератора случайных чисел (класс Random).
//    Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие

public class Task4 {

    private int maxValue = 0;

    private void initMatrix() {

        Scanner sc = new Scanner(System.in);
        int n;
        int m;

        do {
            System.out.println("Введите  число стобцов и строк матрицы");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести положительное целое число");
                sc.next();
            }
            n = Math.abs(sc.nextInt());
        } while (n == 0);

        do {
            System.out.println("Введите число - интервал значений");
            while (!sc.hasNextInt()) {
                System.out.println("Нужно ввести целое число");
                sc.next();
            }
            m = Math.abs(sc.nextInt());
        } while (m == 0);

        sc.close();

        int[][] matrix = new int[n][n];

        int minRandom = -m;
        int maxRandom = m;
        int diffRandom = maxRandom - minRandom;
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(diffRandom + 1) + minRandom;
            }
        }
        findMax(matrix);
    }

    private void findMax(int[][] matrix) {

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt > this.maxValue) {
                    this.maxValue = anInt;
                }
            }
        }
        deleleteMaxValue(matrix);
    }

    private void deleleteMaxValue(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == maxValue) {
                    changeMatrix(matrix, i, j);
                }
            }
        }
    }

    private int[][] changedMatrix;

    private void changeMatrix(int[][] matrix, int iCoordinate, int jCoordinate) {
        int oldMatrixLength = matrix.length;
        changedMatrix = new int[oldMatrixLength - 1][oldMatrixLength - 1];

        int newiCoordinate = 0;
        int newjCoordinate = 0;

        for (int i = 0; i < oldMatrixLength; ++i) {
            for (int j = 0; j < oldMatrixLength; ++j) {

                if (i != iCoordinate) {
                    if (j != jCoordinate) {
                        changedMatrix[newiCoordinate][newjCoordinate] = matrix[i][j];
                        ++newjCoordinate;
                    }

                } else {
                    --newiCoordinate;
                    break;
                }
            }
            ++newiCoordinate;
            newjCoordinate = 0;

        }
        deleleteMaxValue(changedMatrix);
    }

    private void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println();
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }

    public static void main(String[] args) {
        Task4 task4 = new Task4();
        task4.initMatrix();
        task4.printMatrix(task4.changedMatrix);

    }

}
