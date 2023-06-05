public class Freelancer extends Employee {
    public Freelancer(String name, String surname, double salary, int age) {
        super(name, surname, salary, age);
    }

    @Override
    public double calculateSalary() {
        return salary * 20 * 8;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s; Фрилансер; %d лет; Среднемесячная заработная плата (почасовая оплата): %.2f (руб.)",
                surname, name, age, calculateSalary());
    }
}
