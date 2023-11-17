package task1;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListToolsTest {
    ListTools listTools;

    @BeforeEach
    void setUp() {
        listTools = new ListTools();
    }

    @AfterEach
    void tearDown() {
        listTools = null;
    }

    @Test
    @DisplayName("Проверка функции listCompare (равные значения среднего)")
    void listCompare_equal() {
        List<Integer> list1 = Arrays.asList(3, 1, 9, 7);
        List<Integer> list2 = Arrays.asList(1, 5, 9);

        assertEquals("Средние значения равны", listTools.listCompare(list1, list2));
    }

    @Test
    @DisplayName("Проверка функции listCompare (первый имеет большее значение среднего)")
    void listCompare_firstIsBigger() {
        List<Integer> list1 = Arrays.asList(10, 20, 30);
        List<Integer> list2 = Arrays.asList(1, 5, 7, 9);

        assertEquals("Первый список имеет большее среднее значение", listTools.listCompare(list1, list2));
    }

    @Test
    @DisplayName("Проверка функции listCompare (второй имеет большее значение среднего)")
    void listCompare_secondIsBigger() {
        List<Integer> list1 = Arrays.asList(3, 1, 9, 7);
        List<Integer> list2 = Arrays.asList(5, 7, 9);

        assertEquals("Второй список имеет большее среднее значение", listTools.listCompare(list1, list2));
    }

    @Test
    @DisplayName("Проверка функции listCompare (пустой список)")
    void listCompare_emptyList() {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = Arrays.asList(5, 7, 9);

        assertThrows(IllegalArgumentException.class, () -> listTools.listCompare(list1, list2));
    }
}