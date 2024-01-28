package task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Main {
    public static void main(String[] args) {
        backupAllFiles("C:\\Education\\HomeWorks\\JavaCore\\HomeWork04\\src\\main\\java\\task2", "./backup");
    }

    /*
    Написать функцию, создающую резервную копию всех файлов в директории (без поддиректорий)
    во вновь созданную папку ./backup
    */
    public static void backupAllFiles(String sourcePath, String backupPath) {
        try {
            Path path = Path.of(backupPath);

            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }

            for (Path file : Files.newDirectoryStream(Path.of(sourcePath))) {
                if (!Files.isDirectory(file)) {
                    Files.copy(file, Paths.get(backupPath, file.getFileName().toString()), REPLACE_EXISTING);
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
