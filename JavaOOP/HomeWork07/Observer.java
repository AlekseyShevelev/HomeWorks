public interface Observer {
    boolean receiveVacancy(Vacancy vacancy);

    boolean receiveOffer(String nameCompany, double salary);
}
