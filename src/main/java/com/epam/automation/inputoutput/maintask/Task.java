package com.epam.automation.inputoutput.maintask;

import java.awt.image.AreaAveragingScaleFilter;
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
import java.util.regex.Pattern;

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
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("-----")) {
                    directories.add(new Directory());
                    ++i;
                }
                if (line.contains("\\.[a-zA-Z0-9]+$")) {
                    directories.get(i).addFile(Pattern.compile("[^ |].+(\\.[A_Za-z0-9_!~=+-]+)$").matcher(line).toString());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return directories;
    }
    void calculateAndPrintResultOfTxtFile (ArrayList<Directory> directories){
        int sumLengthOfFiles = 0;
        int countOfDirectories = 0;
        int countOffiles = 0;
        for (Directory directory : directories) {
            countOfDirectories++;
            for (String file : directory.files) {
                    countOffiles++;
                    sumLengthOfFiles =+file.length();

            }
        }
        System.out.println("");
    }
}



