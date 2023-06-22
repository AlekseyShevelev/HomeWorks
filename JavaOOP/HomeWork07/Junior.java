public class Junior extends Applicant {
    public Junior(String name, Vacancy.VType vacancyType) {
        super.applicantType = "Юниор";
        super.name = name;
        super.minSalary = random.nextDouble(50000, 80000);
        super.vacancyType = vacancyType;
    }
}
