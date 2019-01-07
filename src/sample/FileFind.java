package sample;

import java.io.File;
import java.util.Scanner;

public class FileFind {
    String[] fileList;

    public FileFind() {
        Settings sett = new Settings();
        File file = new File(sett.getPath());
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
        } else System.out.println("Файл с таким именем не найден.");;
    }

    void start_search() {
        Scanner scanner = new Scanner(System.in);
        String s;
        System.out.println("Для выхода из поиска введите !help");
        System.out.println("Начинаем поиск файлов." +'\n' + "Ввведите имя файла:");
        while((s = scanner.nextLine())!=null)
//            String s = scanner.nextLine();
            if(s.equals("!help")){
                System.out.println("Выход из поиска.");
                break;
            }else {
                find_by_name(s, fileList);
                System.out.println("Ввведите имя файла:");
            }
    }


}