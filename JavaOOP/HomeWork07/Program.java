public class Program {
    public static void main(String[] args) {
        JobAgency jobAgency = new JobAgency();

        Company geekBrains = new Company("GeekBrains", 70000, jobAgency);
        Company google = new Company("Google", 100000, jobAgency);
        Company yandex = new Company("Yandex", 150000, jobAgency);

        Master ivanov = new Master("Ivanov", Vacancy.VType.ANALYST);
        Master petrov = new Master("Petrov", Vacancy.VType.PROJECT_MANAGER);
        Junior suhov = new Junior("Suhov", Vacancy.VType.DEVELOPER);
        Student sidorov = new Student("Sidorov", Vacancy.VType.TESTER);

        jobAgency.registerObserver(ivanov);
        jobAgency.registerObserver(petrov);
        jobAgency.registerObserver(suhov);
        jobAgency.registerObserver(sidorov);

        for (int i = 0; i < 10; i++) {
            geekBrains.needEmployee();
            google.needEmployee();
            yandex.needEmployee();
        }
    }
}
