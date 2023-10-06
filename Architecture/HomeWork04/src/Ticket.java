import java.util.Date;

public class Ticket {
    public int rootNumber;
    public int place;
    public int price;
    public Date date;
    public boolean isValid;

    public Ticket(int rootNumber, int place, int price, Date date, boolean isValid) {
        this.rootNumber = rootNumber;
        this.place = place;
        this.price = price;
        this.date = date;
        this.isValid = isValid;
    }
}
