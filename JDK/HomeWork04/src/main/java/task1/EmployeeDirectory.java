package task1;

import java.util.ArrayList;
import java.util.List;

/*
Создать справочник сотрудников
Необходимо:
Создать класс справочник сотрудников, который содержит внутри
коллекцию сотрудников - каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который возвращает номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник
 */
public class EmployeeDirectory {
    private final List<Employee> employees;

    public EmployeeDirectory() {
        employees = new ArrayList<>();
    }

    // Поиск сотрудника по стажу (может быть список)
    public List<Employee> getEmployeesBySeniority(int seniority) {
        return employees.stream().filter(x -> x.getSeniority() >= seniority).toList();
    }

    // Поиск номера телефона сотрудника по имени (может быть список)
    public List<String> getPhonesByName(String fio) {
        return employees.stream()
                .filter(x -> x.getFio().equals(fio))
                .map(Employee::getPhone)
                .toList();
    }

    // Поиск сотрудника по табельному номеру
    public Employee getEmployeeByNumber(String number) {
        return employees.stream().filter(x -> x.getNumber().equals(number)).findFirst().orElse(null);
    }

    // Добавление нового сотрудника в справочник
    public void addEmployee(String number, String phone, String fio, int seniority) {
        employees.add(new Employee(number, phone, fio, seniority));
    }
}
