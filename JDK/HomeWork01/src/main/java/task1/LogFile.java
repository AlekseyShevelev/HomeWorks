package task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LogFile {
    private static final String fileName = "history.log";

    public static boolean addToLog(String message) {
        try {
            Files.write(Path.of(fileName), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static String getLog() {
        Path file = Path.of(fileName);
        try {
            if (!Files.exists(file)) {
                Files.createFile(file);
                return "";
            }
            return new String(Files.readAllBytes(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
