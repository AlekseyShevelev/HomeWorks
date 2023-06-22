import java.util.Random;

public class Company {
    private static Random random = new Random();
    private String nameCompany;
    private double maxSalary;

    private Publisher jobAgency;

    public Company(String nameCompany, double maxSalary, Publisher jobAgency) {
        this.nameCompany = nameCompany;
        this.maxSalary = maxSalary;
        this.jobAgency = jobAgency;
    }

    public void needEmployee() {
        double salary = random.nextDouble(2500, maxSalary);
        Vacancy.VType type = Vacancy.VType.values()[random.nextInt(4)];
        Vacancy vacancy = new Vacancy(nameCompany, type, salary);

        if (jobAgency.sendVacancy(vacancy)) {
            jobAgency.sendOffer(nameCompany, vacancy.getApplicantName(), salary);
        }
    }
}
