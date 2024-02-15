package task1;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory empDir = initEmployeeDirectory();

        // Поиск сотрудника по стажу (может быть список)
        System.out.println(empDir.getEmployeesBySeniority(10));
        // Поиск номера телефона сотрудника по имени (может быть список)
        System.out.println(empDir.getPhonesByName("Васечкин Петр Васильевич"));
        // Поиск сотрудника по табельному номеру
        System.out.println(empDir.getEmployeeByNumber("00004"));
    }

    private static EmployeeDirectory initEmployeeDirectory() {
        EmployeeDirectory empDir = new EmployeeDirectory();
        empDir.addEmployee("00001", "921-123-45-67", "Петров Василий Иванович", 15);
        empDir.addEmployee("00002", "922-987-65-43", "Распутин Илья Борисович", 12);
        empDir.addEmployee("00003", "931-112-77-15", "Иванова Галина Петровна", 10);
        empDir.addEmployee("00004", "910-567-12-43", "Федорова Анастасия Павловна", 5);
        empDir.addEmployee("00005", "911-234-87-98", "Васечкин Петр Васильевич", 2);
        empDir.addEmployee("00006", "911-234-87-99", "Васечкин Петр Васильевич", 1);
        return empDir;
    }
}
