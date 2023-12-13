import java.awt.*;

public class Scania extends Cars {
    public int vinkelFlak;

    public Scania() {
        nrDoors = 2;
        color = Color.yellow;
        enginePower = 150;
        modelName = "Scania";
        stopEngine();
        vinkelFlak = 0;
        y = 0;
        x = 0;
        carLength = 15;
    }

    protected void höjFlak(int grader) {
        if (getCurrentSpeed() == 0) {
            vinkelFlak += grader;
            if (vinkelFlak > 70) {
                vinkelFlak = 70;
            }
        }
    }

    protected void sänkFlak(int grader) {
        vinkelFlak -= grader;
        if (vinkelFlak < 0) {
            vinkelFlak = 0;
        }
    }

    protected int getVinkelFlak() {
        return vinkelFlak;
    }

    @Override
    protected double speedFactor() {
        if (vinkelFlak == 0) {
            return enginePower * 0.01;
        } else {
            return 0;
        }
    }
    protected void startEngine() {

        if (vinkelFlak == 0){
            currentSpeed = 0.1;
    }
}

}