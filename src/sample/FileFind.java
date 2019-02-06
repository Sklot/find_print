package sample;

import java.io.File;
import java.util.Scanner;

public class FileFind {
    String[] fileList;
    String file_path;

    public FileFind() {
        Settings sett = new Settings();
        File file = new File(sett.getPath());
        file_path = sett.getPath();
        this.fileList = file.list();
    }

    void find_by_name(String string, String[] data) {
        int f = 0;
        for (String s : data
        ) {
            if (string.toLowerCase().equals(s))
                f++;
        }
        if (f > 0) {
            System.out.println("File: " + string + " найден.");
        } else System.out.println("Файл с таким именем не найден.");
    }

    void start_search() {
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Для выхода из поиска введите !help");
        System.out.println("Для списка всех файлов введите !list");
        System.out.println("Начинаем поиск файлов." + '\n' + "Ввведите имя файла:");
        while ((s = scanner.nextLine()) != null)
            if (s.equals("!help")) {
                System.out.println("Выход из поиска.");
                break;
            } else if (s.equals("!list")) {

                show_all_list(fileList, file_path);


            } else {
                find_by_name(s, fileList);
                System.out.println("Ввведите имя файла:");
            }
    }


    void show_all_list(String[] file_data, String file_path) {
        String start_path = file_path;
        for (int i = 0; i < file_data.length; i++) {
            File f = new File(start_path + "\\" + file_data[i]);
            if (f.isDirectory()) {
                System.out.println("dir " + file_data[i]);
                System.out.println("|");
                String[] files = f.list();
                show_all_list(files, f.getPath());

            } else if (f.isFile()) {
                System.out.println(file_data[i]);
            }

        }

    }


}