package com.epam.automation.inputoutput.maintask;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//./src/main/java/com/epam/automation/inputoutput/maintask/resources/maintaskExampl.txt
//[^ |].+(\.[A_Za-z0-9_!~=+-]+)$   (для файла)
//[^ |].*\.(?![A_Za-z0-9_!~=+-]+)$ (для папки)

public class Task {

    public static void main(String[] args) {
        Task task = new Task();
        task.enterPath();
    }

    void enterPath() {
        System.out.println("Введите путь к дирректории либо путь к текстовому файлу.");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String path = reader.readLine();

            File file = new File(path);
            if (file.isDirectory()) {
                printTree(file.toPath(), 0);
            } else if (file.isFile()) {
                calculateAndPrintResultOfTxtFile(readTxtFileAndCreateStructure(file));

            } else enterPath();
        } catch (IOException ex) {
        }
    }

    void printTree(Path path, int depth) throws IOException {
        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);

        if (attr.isDirectory()) {
            DirectoryStream<Path> paths = Files.newDirectoryStream(path);
            System.out.println(marksForDepth("----", depth) + path.getFileName());
            for (Path tempPath : paths) {
                printTree(tempPath, depth + 1);
            }
        } else
            System.out.println(marksForDepth("  ", depth) + path.getFileName());
    }

    String marksForDepth(String markType, int depth) {
        StringBuilder builder = new StringBuilder();
        if (depth != 0) {
            builder.append("|");
        }
        for (int i = 0; i < depth; i++) {
            builder.append(markType);
        }
        return builder.toString();
    }

    ArrayList readTxtFileAndCreateStructure(File file) {
        ArrayList<Directory> directories = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            int i = -1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("-----")) {
                    directories.add(new Directory());
                    ++i;
                }
                if (line.contains("       ")) {
                    directories.get(i).addFile(cutFilesName(line));

                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return directories;
    }

    String cutFilesName(String line) {

        Pattern pattern = Pattern.compile("([^ |].+)\\.[A_Za-z0-9_!~=+-]+$");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            line = matcher.group(1);
        }
        return line;
    }

    void calculateAndPrintResultOfTxtFile(ArrayList<Directory> directories) {
        int sumLengthOfFiles = 0;
        int countOfDirectories = 0;
        int countOfFiles = 0;
        for (Directory directory : directories) {

            countOfDirectories++;
            for (String file : directory.files) {
                countOfFiles++;
                sumLengthOfFiles += file.length();

            }
        }
        System.out.println("Количество папок: " + countOfDirectories + "\n" +
                "Количество файлов: " + countOfFiles + "\n" +
                "Среднее количество файлов в папке: " + countOfFiles / countOfDirectories + "\n" +
                "Среднюю длинну названия файла: " + sumLengthOfFiles / countOfFiles + "\n"
        );
    }
}



