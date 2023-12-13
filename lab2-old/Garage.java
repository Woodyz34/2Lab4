import java.util.ArrayList;
import java.util.List;

public class Garage<T extends Cars> {
    private final int capacity;
    private final List<T> garageCars;

    public Garage(int capacity) {
        this.capacity = capacity;
        garageCars = new ArrayList<>();
    }

    public void addCar(T car) {
        if (garageCars.size() < capacity) {
            garageCars.add(car);
        }
    }
    public void removeCar(T car) {
        garageCars.remove(car);
    }
    protected List<T> getGarageCars() {
        return garageCars;
    }
}