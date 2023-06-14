package presenters;

import java.util.Date;

public interface ViewObserver {
    void onReservationTableEvent(Date orderDate, int tableNo, String name);

    void onChangeReservationTableEvent(int oldReservationId, Date orderDate, int tableNo, String name);
}
