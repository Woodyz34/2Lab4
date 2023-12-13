import java.awt.*;
import java.util.ArrayList;


public class BilTransporter extends Cars{
    private double maxBilLängd;
    private int maxBilar;
    private boolean rampDown;
    public ArrayList<Cars> bilarLastade = new ArrayList<>();

    public BilTransporter() {
        modelName = "Mack";
        nrDoors = 2;
        color = Color.red;
        enginePower = 669;
        stopEngine();
        maxBilar = 3;
        maxBilLängd = 5;
        rampDown = false;
        y = 0;
        x = 0;
        carLength = 25;
    }


    protected void höjRamp() {
            rampDown = false;
    }
    protected ArrayList<Cars> getLoadedCars() {return bilarLastade;}


    protected void sänkRamp() {
        if (getCurrentSpeed() == 0) {
            rampDown = true;
        }
    }
    protected void bilLasta(Cars bil) {
        if (
            rampDown
            && maxBilLängd >= bil.carLength
            && bilarLastade.size() < maxBilar
            && Math.abs(bil.getX() - getX()) < 1
            && Math.abs(bil.getY() - getY()) < 1
            && !ärLastad){
            bilarLastade.add(bil);
            bil.setX(x);
            bil.setY(y);
            bil.ärLastad = true;
        }
    }
    protected void bilAvlasta(int hurMånga) {
        if (rampDown && !bilarLastade.isEmpty()) {
            for (int i = bilarLastade.size()-1; 0 < hurMånga; i--){
            bilarLastade.remove(i);
            hurMånga--;
            bilarLastade.get(i).setX(x+1);
            bilarLastade.get(i).setY(y+1);

            }
        }
    }

    private boolean getflakposition() {
        return rampDown;
    }

    protected double speedFactor() {
        if (!rampDown) {
            return enginePower * 0.01;
        } else {
            return 0;
        }
    }
    protected void startEngine() {

        if (!rampDown){
            currentSpeed = 0.1;
        }
    }
    public void move() {
        if (direction == 0) {
            y += currentSpeed;
            for (Cars cars : bilarLastade) {
                cars.setY(y);
                cars.setX(x);
            }
        } else if (direction == 1) {
            x += currentSpeed;
            for (Cars cars : bilarLastade) {
                cars.setY(y);
                cars.setX(x);
            }
        } else if (direction == 2) {
            y -= currentSpeed;
            for (Cars cars : bilarLastade) {
                cars.setY(y);
                cars.setX(x);
            }
        } else if (direction == 3) {
            x -= currentSpeed;
            for (Cars cars : bilarLastade) {
                cars.setY(y);
                cars.setX(x);
            }
        }
    }
}
