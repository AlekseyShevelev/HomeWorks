public class Student extends Applicant {
    public Student(String name, Vacancy.VType vacancyType) {
        super.applicantType = "Студент";
        super.name = name;
        super.minSalary = random.nextDouble(2000, 3000);
        super.vacancyType = vacancyType;
    }
}
