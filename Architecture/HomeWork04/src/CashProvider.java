public class CashProvider {
    private long numberCars;
    private boolean isAuthorization;

    public CashProvider(long numberCars, boolean isAuthorization) {
        this.numberCars = numberCars;
        this.isAuthorization = isAuthorization;
    }

    public long getNumberCars() {
        return numberCars;
    }

    public void setNumberCars(long numberCars) {
        this.numberCars = numberCars;
    }

    public boolean isAuthorization() {
        return isAuthorization;
    }

    public void setAuthorization(boolean authorization) {
        isAuthorization = authorization;
    }

    public boolean authorization(Customer customer) {
        System.out.println("Авторизация...");
        return true;
    }

    public boolean buy(int price) {
        System.out.println("Покупка...");
        return true;
    }
}
