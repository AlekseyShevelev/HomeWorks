package task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Петров Иван Сергеевич",
                "Директор",
                "+7(921)987-65-43",
                180000,
                LocalDate.of(1960, 3, 25));
        System.out.println(employee);
        employee.printInfo();
        System.out.println("***");

        Manager manager = new Manager("Медведев Анатолий Дмитриевич",
                "Директор",
                "+7(950)123-45-67",
                350000,
                LocalDate.of(1965, 9, 11));

        List<Employee> employees = new ArrayList<>();
        employees.add(manager);
        employees.add(employee);
        employees.add(new Employee("Иванов Сергей Петрович",
                "Инженер",
                "+7(911)534-77-22",
                80000,
                LocalDate.of(1974, 4, 10)));
        employees.add(new Employee("Сидоров Василий Андреевич",
                "Тимлид",
                "+7(912)555-78-03",
                120000,
                LocalDate.of(1970, 6, 5)));
        employees.add(new Employee("Зайкина Лидия Васильевна",
                "Тестер",
                "+7(915)789-99-51",
                75000,
                LocalDate.of(1985, 2, 28)));
        employees.add(new Employee("Васильева Лидия Петровна",
                "Аналитик",
                "+7(927)234-31-80",
                140000,
                LocalDate.of(1975, 11, 14)));

        printEmployees(employees);
        Manager.increaseEmployeeSalary(employees, 45, 20000);
        System.out.println();
        printEmployees(employees);
        System.out.println(getAvgSalaryAndAge(employees));
        System.out.println();

        int year1 = 1980;
        int month1 = 4;
        int day1 = 25;
        int year2 = 2024;
        int month2 = 11;
        int day2 = 5;
        int compareResult = employee.compareDates(year1, month1, day1, year2, month2, day2);

        System.out.printf("%02d.%02d.%d %s %02d.%02d.%d\n",
                day1, month1, year1,
                compareResult > 0 ? "больше" : (compareResult < 0 ? "меньше" : "равно"),
                day2, month2, year2);
    }

    public static void printEmployees(List<Employee> employees) {
        for (Employee emp: employees) {
            System.out.println(emp);
        }
    }
//    public static void increaseEmployeeSalary(List<Employee> employees, int age, int value) {
//        for (Employee emp: employees) {
//            if (emp.getAge() >= age) {
//                emp.increaseSalary(value);
//            }
//        }
//    }

    public static String getAvgSalaryAndAge(List<Employee> employees) {
        double avgSalary = employees.stream().
                mapToDouble(Employee::getSalary).
                average().orElseThrow();
        double avgAge = employees.stream().
                mapToDouble(Employee::getAge).
                average().orElseThrow();

        return String.format("Средняя зарплата: %s, средний возраст: %s", avgSalary, avgAge);
    }

    public static AvarageResponseDTO getAverage(List<Employee> employees) {
        return AvarageResponseDTO.builder()
                .averageAge(employees.stream().mapToDouble(Employee::getAge).average().orElseThrow())
                .averageSalary(employees.stream().mapToDouble(Employee::getAge).average().orElseThrow())
                .averageFIOLetters((int) employees.stream().mapToInt(x -> x.getFio().length()).average().orElseThrow())
                .build();
    }
}
