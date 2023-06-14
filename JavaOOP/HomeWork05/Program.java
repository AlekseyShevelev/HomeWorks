import models.TableModel;
import presenters.BookingPresenter;
import views.BookingView;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        BookingView bookingView = new BookingView();
        TableModel tableModel = new TableModel();
        BookingPresenter bookingPresenter = new BookingPresenter(bookingView, tableModel);
        bookingPresenter.showTables();
        System.out.println("----------");
        bookingView.reservationTableEvent(new Date(), 103, "Станислав");
        System.out.println("----------");
        bookingView.reservationTableEvent(new Date(), 110, "Петр");

        System.out.println("----------");
        bookingView.changeReservationTable(9001, new Date(), 104, "Алексей");
        System.out.println("----------");
        bookingView.changeReservationTable(9003, new Date(), 105, "Александр");
        System.out.println("----------");
        bookingView.changeReservationTable(9002, new Date(), 110, "Александр");
    }
}
