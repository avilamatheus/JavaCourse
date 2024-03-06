package application;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Obter o ClassLoader para carregar recursos do classpath
        ClassLoader classLoader = Main.class.getClassLoader();

        String filePath;
        try {
            filePath = classLoader.getResource("tests.txt").getFile();
        } catch (NullPointerException e) {
            System.out.println("Error: File not found");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}