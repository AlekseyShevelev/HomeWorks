package presenters;

import models.Table;

import java.util.Collection;
import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final View bookingView;
    private final Model tableModel;

    public BookingPresenter(View bookingView, Model tableModel) {
        this.bookingView = bookingView;
        this.tableModel = tableModel;
        bookingView.setObserver(this);
    }

    private Collection<Table> loadTables() {
        return tableModel.loadTables();
    }

    public void showTables() {
        bookingView.updateTablesView(loadTables());
    }

    private void showReservationTableResult(int tableNo, int reservationNo) {
        bookingView.updateReservationTableResult(tableNo, reservationNo);
    }

    private void showDeleteReservationResult(int oldReservationId, int deletionResult) {
        bookingView.updateDeleteReservationResult(oldReservationId, deletionResult);
    }

    @Override
    public void onReservationTableEvent(Date orderDate, int tableNo, String name) {
        int reservationNo = tableModel.reservationTable(orderDate, tableNo, name);
        showReservationTableResult(tableNo, reservationNo);
    }

    @Override
    public void onChangeReservationTableEvent(int oldReservationId, Date orderDate, int tableNo, String name) {
        int deletionResult = tableModel.deleteReservation(oldReservationId);
        showDeleteReservationResult(oldReservationId, deletionResult);

        if (deletionResult == 0) {
            int reservationNo = tableModel.reservationTable(orderDate, tableNo, name);
            showReservationTableResult(tableNo, reservationNo);
        }
    }
}
