public class CarFactory {
    CarInWorld carWorld = CarInWorld.getInstance();
    public void CreateVolvo(){
        Cars volvo = new Volvo240();
        volvo.setY(carWorld.cars.size()*56);
        carWorld.cars.add(volvo);
    }
    public void CreateSaab95(){
        Cars saab = new Saab95();
        saab.setY(carWorld.cars.size()*56);
        carWorld.cars.add(saab);
    }
    public void CreateScania(){
        Cars scania = new Scania();
        scania.setY(carWorld.cars.size()*56);
        carWorld.cars.add(scania);
    }
}
