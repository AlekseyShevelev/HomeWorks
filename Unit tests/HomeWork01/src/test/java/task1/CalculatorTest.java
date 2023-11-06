package task1;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        calculator = null;
    }

    @Test
    @DisplayName("Проверка суммирования")
    void testAdd() {
        assertThat(calculator.add(2, 3))
                .isEqualTo(5);
    }

    @Test
    @DisplayName("Проверка вычитания")
    void testSubtract() {
        assertThat(calculator.subtract(3, 2))
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Проверка умножения")
    void testMultiply() {
        assertThat(calculator.multiply(2, 3))
                .isEqualTo(6);
    }

    @Test
    @DisplayName("Проверка деления")
    void testDivide() {
        assertThat(calculator.divide(4, 2))
                .isEqualTo(2.0);
    }

    @Test
    @DisplayName("Проверка деления на ноль")
    void testDivideByZero() {
        assertThatThrownBy(() -> calculator.divide(1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка вычисления скидки")
    void testCalculateDiscount() {
        assertThat(calculator.calculateDiscount(1000, 5))
                .isEqualTo(950.0);
    }

    @Test
    @DisplayName("Проверка вычисления скидки для нулевой суммы")
    void testCalculateDiscountZeroAmount() {
        assertThatThrownBy(() -> calculator.calculateDiscount(0, 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка вычисления нулевой скидки")
    void testCalculateZeroDiscount() {
        assertThatThrownBy(() -> calculator.calculateDiscount(1000, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Проверка вычисления 100% скидки")
    void testCalculate100Discount() {
        assertThatThrownBy(() -> calculator.calculateDiscount(1000, 100))
                .isInstanceOf(IllegalArgumentException.class);
    }
}