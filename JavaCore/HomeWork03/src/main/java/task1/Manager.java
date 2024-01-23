package task1;

import java.time.LocalDate;
import java.util.List;

public class Manager extends Employee {
    public Manager(String fio, String position, String phone, double salary, LocalDate birthDate) {
        super(fio, position, phone, salary, birthDate);
    }

    public static void increaseEmployeeSalary(List<Employee> employees, int age, int value) {
        for (Employee emp: employees) {
            if (!(emp instanceof Manager) && emp.getAge() >= age) {
                emp.increaseSalary(value);
            }
        }
    }
}
