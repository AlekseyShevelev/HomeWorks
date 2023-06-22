public interface Publisher {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    boolean sendVacancy(Vacancy vacancy);

    void sendOffer(String nameCompany, String applicantName, double salary);
}
