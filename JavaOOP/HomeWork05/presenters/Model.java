package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    /**
     * Получение списка всех столиков
     * 
     * @return
     */
    Collection<Table> loadTables();

    /**
     * Бронирование столика
     * 
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя клиента
     * @return Номер брони
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Удаление брони
     * 
     * @param oldReservationId Номер удаляемой брони
     * @return Результат удаления
     */
    int deleteReservation(int oldReservationId);
}
