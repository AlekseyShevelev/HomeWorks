public class Chocolate extends Product {
    enum Type {
        Dark("Темный"),
        Milk("Молочный"),
        White("Белый");
        private String title;
        Type(String title) {
            this.title = title;
        }
        @Override
        public String toString () {
            return title;
        }
    }

    private Type type; // Тип
    private double kcal; // Калорийность
    
    public Chocolate(String brand, String name, double price, Chocolate.Type type, double kcal) {
        super(brand, name, price);
        this.type = type;
        this.kcal = kcal;
    }

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public double getKcal() {
        return kcal;
    }
    public void setKcal(double kcal) {
        this.kcal = kcal;
    }
    
    @Override
    public String displayInfo() {
        return String.format("[Шоколад] %s - %s - %f [%s; %f Ккал]",
                brand, name, price, type, kcal);
    }
}
