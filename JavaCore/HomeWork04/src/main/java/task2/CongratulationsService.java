package task2;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class CongratulationsService {
    public static enum Holiday {
        NEW_YEAR(Month.JANUARY, 1),
        MENS_DAY(Month.FEBRUARY, 23),
        WOMENS_DAY(Month.MARCH, 8);

        private Month month;
        private int day;

        Holiday(Month month, int day) {
            this.month = month;
            this.day = day;
        }

        public Month getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }
    }

    public static void sendGreetings(List<Customer> customers, LocalDate date) {
        for (Customer customer: customers) {
            if (date.getMonth().equals(Holiday.NEW_YEAR.getMonth())
                    && date.getDayOfMonth() == Holiday.NEW_YEAR.getDay()) {
                System.out.printf("Дорогой(ая) %s! Поздравляю Вас с Новым Годом!\n", customer.getFio());
            } else if (date.getMonth().equals(Holiday.MENS_DAY.getMonth())
                    && date.getDayOfMonth() == Holiday.MENS_DAY.getDay()
                    && customer.getGender().equals(Customer.Gender.MALE)) {
                System.out.printf("Дорогой %s! Поздравляю Вас с Днем защитника Отечества!\n", customer.getFio());
            } else if (date.getMonth().equals(Holiday.WOMENS_DAY.getMonth())
                    && date.getDayOfMonth() == Holiday.WOMENS_DAY.getDay()
                    && customer.getGender().equals(Customer.Gender.FEMALE)) {
                System.out.printf("Дорогая %s! Поздравляю Вас с Международным женским днем!\n", customer.getFio());
            }
        }
    }
}
