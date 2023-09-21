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
        if(models.isEmpty()) {
            throw new Exception("Должна быть хотя бы одна модель");
        }
        else {
            this.models = models;
        }
        this.flashes = flashes;
        if(cameras.isEmpty()) {
            throw new Exception("Должна быть хотя бы одна камера");
        }
        else {
            this.cameras = cameras;
        }
    }

    public Type method1(Type t) {
        return t;
    }

    public Type1 method2(Type1 t1, Type2 t2) {
        return t1;
    }
}
