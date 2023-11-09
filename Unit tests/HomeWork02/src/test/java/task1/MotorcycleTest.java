package task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {
    Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        motorcycle = new Motorcycle("Harley-Davidson", "V-Rod", 2010);
    }

    @AfterEach
    void tearDown() {
        motorcycle = null;
    }

    @Test
    @DisplayName("Проверка класса объекта")
    void hasCorrectClass() {
        assertTrue(motorcycle instanceof Vehicle);
    }

    @Test
    @DisplayName("Проверка количества колес")
    void checkNumberOfWheels() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    @DisplayName("Проверка скорости в режиме тестового вождения")
    void checkSpeedInTestDrive() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    @DisplayName("Проверка скорости в режиме парковки")
    void checkSpeedAfterParking() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}