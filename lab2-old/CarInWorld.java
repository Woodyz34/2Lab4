import java.util.ArrayList;

public class CarInWorld {
    private static CarInWorld instance;
    public ArrayList<Cars> cars = new ArrayList<>();

    private CarInWorld() {
        // Privat konstruktor för att förhindra direkt instansiering
    }

    public static CarInWorld getInstance() {
        if (instance == null) {
            instance = new CarInWorld();
        }
        return instance;
    }

    public void CheckCarInWindow() {
        for (Cars car : cars) {
            if (car.getX() > 700) {
                car.setX(700);
                car.currentSpeed = 0;
                car.direction = 3;
            }
            if (car.getX() < 0) {
                car.direction = 1;
                car.currentSpeed = 0;
                car.setX(0);
            }
        }
    }
}


