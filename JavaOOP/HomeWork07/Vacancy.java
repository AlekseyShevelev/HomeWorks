public class Vacancy {
    public enum VType {
        PROJECT_MANAGER,
        ANALYST,
        DEVELOPER,
        TESTER
    }

    private String companyName;
    private VType vacancyType;
    private double salary;
    private String applicantName;

    public Vacancy(String companyName, Vacancy.VType vacancyType, double salary) {
        this.companyName = companyName;
        this.vacancyType = vacancyType;
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public VType getVacancyType() {
        return vacancyType;
    }

    public double getSalary() {
        return salary;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    @Override
    public String toString() {
        return String.format("Вакансия [Компания: %s, тип: %s, з/п: %f]", companyName, vacancyType, salary);
    }
}
