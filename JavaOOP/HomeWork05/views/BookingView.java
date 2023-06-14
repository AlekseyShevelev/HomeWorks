package views;

import models.Table;
import presenters.View;
import presenters.ViewObserver;

import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private ViewObserver observer;

    @Override
    public void setObserver(ViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void updateTablesView(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void updateReservationTableResult(int tableNo, int reservationNo) {
        if (reservationNo == -1) {
            System.out.printf("Бронь столика #%d невозможна.\n", tableNo);
        } else {
            System.out.printf("Столик #%d успешно забронирован. Номер вашей брони: #%d.\n", tableNo, reservationNo);
        }
    }

    @Override
    public void updateDeleteReservationResult(int oldReservationId, int deletionResult) {
        if (deletionResult == -1) {
            System.out.printf("Бронь #%d не существует.\n", oldReservationId);
        } else {
            System.out.printf("Бронь #%d успешно отменена.\n", oldReservationId);
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования),
     * бронирование столика
     * 
     * @param reservationDate Дата бронирования
     * @param tableNo         Номер столика
     * @param name            мя клиета
     */
    public void reservationTableEvent(Date reservationDate, int tableNo, String name) {
        observer.onReservationTableEvent(reservationDate, tableNo, name);
    }

    /**
     * Действие клиента (пользователь нажал на кнопку изменения бронирования),
     * изменение бронирование столика
     * 
     * @param oldReservationId  Номер старой брони
     * @param reservationDate   Дата бронирования
     * @param tableNo           Номер столика
     * @param name              Имя клиета
     */
    public void changeReservationTable(int oldReservationId, Date reservationDate, int tableNo, String name) {
        observer.onChangeReservationTableEvent(oldReservationId, reservationDate, tableNo, name);
    }
}
