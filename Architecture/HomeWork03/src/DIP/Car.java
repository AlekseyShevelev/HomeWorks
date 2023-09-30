package DIP;

public class Car {
    private String model;
    private IEngine engine;

    public Car(String model, IEngine engine) {
        this.model = model;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public IEngine getEngine() {
        return engine;
    }

    public void engineStart() {
        engine.start();
    }
}
