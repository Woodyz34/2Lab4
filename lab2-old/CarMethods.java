import java.util.Random;

public class CarMethods {
    CarInWorld carWorld = CarInWorld.getInstance();
    Controller controller = new Controller();
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Cars car : carWorld.cars)
        {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Cars car : carWorld.cars)
        {
            car.brake(brake);
        }
    }
    void startCars() {
        for (Cars car : carWorld.cars) {
            if (car.currentSpeed == 0) {
                car.startEngine();
            }
        }
    }
    void stopCars() {
        for (Cars car : carWorld.cars) {
            car.currentSpeed = 0;

        }
    }
    void höjFlak(){
        for(Cars car : carWorld.cars) {
            if (car instanceof Scania)
                ((Scania) car).höjFlak(25);
        }
    }
    void sänkFlak(){
        for(Cars car : carWorld.cars) {
            if (car instanceof Scania)
                ((Scania) car).sänkFlak(25);
        }
    }
    void turboOn(){
        for (Cars car : carWorld.cars) {
            if (car instanceof Saab95)
                ((Saab95)car).setTurboOn();
        }
    }

    void turboOff(){
        for(Cars car : carWorld.cars) {
            if (car instanceof Saab95)
                ((Saab95) car).setTurboOff();
        }
    }
    public void addCar() {
        if (carWorld.cars.size() < 10) {
            CarFactory createCar = new CarFactory();
            Random rand = new Random();
            int int_random = rand.nextInt(3);
            if (int_random == 0){
                createCar.CreateVolvo();}
            else if (int_random == 1){
                createCar.CreateSaab95();}
            else{
                createCar.CreateScania();}
        }
    }

    public void removeCar() {
        if (!carWorld.cars.isEmpty()) {
            carWorld.cars.remove(carWorld.cars.size()-1);
        }
    }
}
