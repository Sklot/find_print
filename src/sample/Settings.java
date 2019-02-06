package sample;

import java.io.*;
import java.util.Scanner;

class Settings {
    private String path;

    public String getPath() {
        return path;
    }

    private void setPath(String path) {
        this.path = path;
    }

    public Settings() {
        File file = new File("src/settings.txt");
        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                try {
                    String path = reader.readLine();
                    if (path != null) {
                        setPath(path);
                    } else writePath(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            writePath(file);
        }
    }

    private void writePath(File file) {
        try {
            FileWriter writer = new FileWriter(file);
            System.out.println("Введите адрес папки:");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            writer.write(path);
            setPath(path);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}