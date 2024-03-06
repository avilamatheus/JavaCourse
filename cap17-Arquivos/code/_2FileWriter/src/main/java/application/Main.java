package application;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path = "/home/mats/Documents/dev/JavaCourse/cap17-Arquivos/code/_2FileWriter/src/main/resources/";

        String fileName = "test.txt";
        path = path + fileName;

        String[] lines = new String[] {"Criciúma", "Tigre", "Carvoeiro"};

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}