public class Master extends Applicant {
    public Master(String name, Vacancy.VType vacancyType) {
        super.applicantType = "Мастер";
        super.name = name;
        super.minSalary = random.nextDouble(80000, 100000);
        super.vacancyType = vacancyType;
    }
}
