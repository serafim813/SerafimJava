package ru.intensive.dz6;
import ru.intensive.dz4.StaticInnerUser;

import java.io.File;

public class FolderUtils {
    public static void printFolders(String path) {
        File folder = new File(path);
        if (folder.isDirectory()) {
            System.out.println(folder.getAbsolutePath());
            File[] subFolders = folder.listFiles();
            if (subFolders != null) {
                for (File subFolder : subFolders) {
                    printFolders(subFolder.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        FolderUtils staticInnerUser = new FolderUtils();
        staticInnerUser.printFolders("/Users/mac/Downloads/SerafimJava/src/main/java/ru");
    }
}

