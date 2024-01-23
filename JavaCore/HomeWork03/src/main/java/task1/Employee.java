package task1;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@AllArgsConstructor
@Data
public class Employee {
    private String fio;
    private String position;
    private String phone;
    private double salary;
    private LocalDate birthDate;

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public void printInfo() {
        System.out.println(this);
    }

    public void increaseSalary(int value) {
        this.salary += value;
    }

    public int compareDates(int year1, int month1, int day1,
                            int year2, int month2, int day2) {
        int date1 = day1 + month1 * 100 + year1 * 10000;
        int date2 = day2 + month2 * 100 + year2 * 10000;
        return date1 - date2;
    }
}
