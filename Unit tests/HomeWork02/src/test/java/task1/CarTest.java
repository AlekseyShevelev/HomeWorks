package task1;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car;

    @BeforeEach
    void setUp() {
        car = new Car("Hyundai", "Solaris", 2019);
    }

    @AfterEach
    void tearDown() {
        car = null;
    }

    @Test
    @DisplayName("Проверка класса объекта")
    void hasCorrectClass() {
        assertTrue(car instanceof Vehicle);
    }

    @Test
    @DisplayName("Проверка количества колес")
    void checkNumberOfWheels() {
        assertEquals(4, car.getNumWheels());
    }

    @Test
    @DisplayName("Проверка скорости в режиме тестового вождения")
    void checkSpeedInTestDrive() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    @DisplayName("Проверка скорости в режиме парковки")
    void checkSpeedAfterParking() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }
}