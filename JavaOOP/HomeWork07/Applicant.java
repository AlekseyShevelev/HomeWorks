import java.util.Random;

public class Applicant implements Observer {
    protected static Random random = new Random();
    protected String applicantType;
    protected String name;
    protected double minSalary;
    protected Vacancy.VType vacancyType;

    public String getName() {
        return name;
    }

    @Override
    public boolean receiveVacancy(Vacancy vacancy) {
        if (vacancyType == vacancy.getVacancyType()) {
            if (minSalary <= vacancy.getSalary()) {
                System.out.printf("%s %s (%.2f) >>> Мне нужна эта работа! (%s - %.2f)\n",
                        applicantType, name, minSalary, vacancy.getCompanyName(), vacancy.getSalary());
                minSalary = vacancy.getSalary();
                vacancy.setApplicantName(name);
                return true;
            } else {
                System.out.printf("%s %s (%.2f) >>> Я найду работу получше! (%s - %.2f)\n",
                        applicantType, name, minSalary, vacancy.getCompanyName(), vacancy.getSalary());
                return false;
            }
        } else {
            System.out.printf("%s %s (%s) >>> Эта работа мне не подходит (%s - %s)\n",
                    applicantType, name, vacancyType, vacancy.getCompanyName(), vacancy.getVacancyType());
            return false;
        }
    }

    @Override
    public boolean receiveOffer(String nameCompany, double salary) {
        if (minSalary <= salary) {
            System.out.printf("%s %s (%.2f) >>> Я принимаю ваше предложение! (%s - %.2f)\n",
                    applicantType, name, minSalary, nameCompany, salary);
            return true;
        } else {
            System.out.printf("%s %s (%.2f) >>> Мне нужна зарплата побольше! (%s - %.2f)\n",
                    applicantType, name, minSalary, nameCompany, salary);
            return false;
        }
    }
}
