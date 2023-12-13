import java.awt.*;

public class Saab95 extends Cars{
    private boolean turboOn;
    public Saab95(){
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
	    turboOn = false;
        modelName = "Saab95";
        stopEngine();
        y = 0;
        x = 0;
        carLength = 4.5;
    }
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    protected void setTurboOn(){
        turboOn = true;
    }

    protected void setTurboOff() {
        turboOn = false;
    }

    public boolean getTurbo(){
        return turboOn;
    }

}
