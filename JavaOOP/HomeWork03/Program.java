import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Program {

    static Random random = new Random();

    static Employee generateEmployee() {
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий",
                "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов",
                "Горбунов", "Лыткин", "Соколов" };
        int age = random.nextInt(18, 70);
        int type = random.nextInt(1, 3);

        if (type == 1) {
            int salary = random.nextInt(20000, 80000);

            return new Worker(
                    names[random.nextInt(names.length)],
                    surnames[random.nextInt(surnames.length)],
                    salary,
                    age);
        } else {
            int salary = random.nextInt(1000, 5000);

            return new Freelancer(
                    names[random.nextInt(names.length)],
                    surnames[random.nextInt(surnames.length)],
                    salary,
                    age);
        }
    }

    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = generateEmployee();
        }

        Arrays.sort(employees);
        showEmployees(employees);

        Arrays.sort(employees, new SalaryComparator());
        showEmployees(employees);

        Arrays.sort(employees, new AgeComparator());
        showEmployees(employees);

        Arrays.sort(employees, new AgeComparator().reversed());
        showEmployees(employees);
    }

    private static void showEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("--------------------------");
    }
}
