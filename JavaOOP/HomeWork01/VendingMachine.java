import java.util.List;

public class VendingMachine {
    private final List<Product> products;

    public VendingMachine(List<Product> products) {
        this.products = products;
    }

    public BottleOfWater getBottleOfWater(double volume) {
        for (Product product : products) {
            if (product instanceof BottleOfWater) {
                if (((BottleOfWater) product).getVolume() == volume) {
                    return (BottleOfWater) product;
                }
            }
        }
        return null;
    }

    public Chocolate getChocolate(Chocolate.Type type) {
        for (Product product : products) {
            if (product instanceof Chocolate) {
                if (((Chocolate) product).getType() == type) {
                    return (Chocolate) product;
                }
            }
        }
        return null;
    }
}