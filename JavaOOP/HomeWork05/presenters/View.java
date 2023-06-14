package presenters;

import models.Table;

import java.util.Collection;

public interface View {
    void setObserver(ViewObserver observer);

    void updateTablesView(Collection<Table> tables);

    void updateReservationTableResult(int tableNo, int reservationNo);

    void updateDeleteReservationResult(int oldReservationId, int deletionResult);
}
