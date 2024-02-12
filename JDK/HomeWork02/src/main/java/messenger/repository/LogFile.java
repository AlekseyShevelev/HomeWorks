package messenger.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LogFile implements Repository {
    private static final String LOG_FILE = "src/main/java/messenger/repository/history.log";

    public boolean addToLog(String message) {
        String text = message + "\n";

        try {
            Files.write(Path.of(LOG_FILE), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public String getLog() {
        Path file = Path.of(LOG_FILE);
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
