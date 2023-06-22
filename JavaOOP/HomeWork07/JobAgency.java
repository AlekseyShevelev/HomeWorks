import java.util.ArrayList;
import java.util.List;

public class JobAgency implements Publisher {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

        if (observers.size() == 0) {
            System.out.println("Больше нет соискателей!");
        }
    }

    @Override
    public boolean sendVacancy(Vacancy vacancy) {
        for (Observer observer : observers) {
            if (observer.receiveVacancy(vacancy)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void sendOffer(String nameCompany, String applicantName, double salary) {
        for (Observer observer : observers) {
            if (observer instanceof Applicant
                    && ((Applicant) observer).getName().equals(applicantName)
                    && observer.receiveOffer(nameCompany, salary)) {
                removeObserver(observer);
                break;
            }
        }
    }
}
