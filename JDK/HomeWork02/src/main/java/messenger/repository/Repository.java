package messenger.repository;

public interface Repository {
    boolean addToLog(String message);
    String getLog();
}
