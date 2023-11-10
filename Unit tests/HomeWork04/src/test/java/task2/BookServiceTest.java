package task2;

import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    BookService bookService;
    BookRepository bookRepositoryMock;

    @BeforeEach
    void setUp() {
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @AfterEach
    void tearDown() {
        bookRepositoryMock = null;
        bookService = null;
    }

    @Test
    @DisplayName("Проверка функции findBookById при помощи mock bookRepository")
    void testFindBookById() {
        String id = "1234567";
        bookService.findBookById(id);
        verify(bookRepositoryMock).findById(id);
    }

    @Test
    @DisplayName("Проверка функции findAllBooks при помощи mock bookRepository")
    void testFindAllBooks() {
        bookService.findAllBooks();
        verify(bookRepositoryMock).findAll();
    }
}