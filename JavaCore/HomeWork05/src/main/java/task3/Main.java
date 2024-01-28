package task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Education\\HomeWorks\\JavaCore\\HomeWork05\\backup";
        String files = "Customer.java Order.java Product.java";
        addPrefix(path, files, "bkp_");
    }

    /*
    Написать функцию, добавляющую префикс к каждому из набора файлов,
    названия которых переданы ей в качестве параметров через пробел.
    */
    public static void addPrefix(String path, String files, String prefix) {
        List<String> filesList = new ArrayList<>(List.of(files.split(" ")));

        try {
            for (String file : filesList) {
                Files.move(Paths.get(path, file), Paths.get(path, prefix + file), REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
