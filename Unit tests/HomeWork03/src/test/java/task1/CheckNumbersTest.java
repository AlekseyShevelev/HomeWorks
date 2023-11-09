package task1;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CheckNumbersTest {
    CheckNumbers checkNumbers;

    @BeforeEach
    void setUp() {
        checkNumbers = new CheckNumbers();
    }

    @AfterEach
    void tearDown() {
        checkNumbers = null;
    }

    // Проверки функции evenOddNumber
    @Test
    @DisplayName("Проверка функции evenOddNumber с четным числом")
    void evenOddNumberWithEvenNumber() {
        assertTrue(checkNumbers.evenOddNumber(4));
    }

    @Test
    @DisplayName("Проверка функции evenOddNumber с нечетным числом")
    void evenOddNumberWithOddNumber() {
        assertFalse(checkNumbers.evenOddNumber(5));
    }

    @Test
    @DisplayName("Проверка функции evenOddNumber с 0")
    void evenOddNumberWithZeroNumber() {
        assertTrue(checkNumbers.evenOddNumber(0));
    }

    @Test
    @DisplayName("Проверка функции evenOddNumber с отрицательным числом")
    void evenOddNumberWithNegativeNumber() {
        assertTrue(checkNumbers.evenOddNumber(-4));
    }

    // Проверки функции numberInInterval
    @Test
    @DisplayName("Проверка функции numberInInterval с числом в интревале")
    void numberInIntervalInside() {
        assertTrue(checkNumbers.numberInInterval(50));
    }

    @Test
    @DisplayName("Проверка функции numberInInterval с числом равным левой границе интервала")
    void numberInIntervalStartValue() {
        assertTrue(checkNumbers.numberInInterval(25));
    }

    @Test
    @DisplayName("Проверка функции numberInInterval с числом равным правой границе интервала")
    void numberInIntervalEndValue() {
        assertTrue(checkNumbers.numberInInterval(100));
    }

    @Test
    @DisplayName("Проверка функции numberInInterval с числом меньше левой границы интервала")
    void numberInIntervalLessStart() {
        assertFalse(checkNumbers.numberInInterval(10));
    }

    @Test
    @DisplayName("Проверка функции numberInInterval с числом больше правой границы интервала")
    void numberInIntervalMoreEnd() {
        assertFalse(checkNumbers.numberInInterval(200));
    }

    @Test
    @DisplayName("Проверка функции numberInInterval с отрицательным числом")
    void numberInIntervalNegativeValue() {
        assertFalse(checkNumbers.numberInInterval(-50));
    }
}