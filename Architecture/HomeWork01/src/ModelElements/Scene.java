package ModelElements;

import java.util.List;

public class Scene {
    public int id;
    public List<PoligonalModel> models;
    public List<Flash> flashes;
    public List<Camera> cameras;

    public Scene (int id,
                  List<PoligonalModel> models,
                  List<Flash> flashes,
                  List<Camera> cameras) throws Exception {
        this.id = id;
        if(!models.isEmpty()) {
            this.models = models;
        }
        else {
            throw new Exception("Должна быть хотя бы одна модель");
        }
        this.flashes = flashes;
        if(!cameras.isEmpty()) {
            this.cameras = cameras;
        }
        else {
            throw new Exception("Должна быть хотя бы одна камера");
        }
    }

    public <T> T method1(T flash) {
        return flash;
    }

    public <T, E> T method2(T flash, E camera) {
        return flash;
    }
}
