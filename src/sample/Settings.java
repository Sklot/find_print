package sample;

import java.io.File;

public class Settings {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Settings() {

    }

    public static boolean isCreate(){
        File file = new File("src/Files/settings.txt");
        if (file.exists()) {
            return true;
        }
        return false;
    }


}