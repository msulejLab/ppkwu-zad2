package pl.ppkwu.zad.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class IOUtils {

    public static void writeToFile(File file, String message) throws IOException {
        FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(message);
        bufferedWriter.close();
    }

    public static String getInput(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("(" + name + "):: ");
        return scanner.nextLine();
    }
}