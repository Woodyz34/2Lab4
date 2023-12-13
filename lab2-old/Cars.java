import java.awt.*;
public abstract class Cars implements Movable {
    protected boolean ärLastad = false;
    protected double carLength;
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected int direction = 1;
    protected double x;
    protected double y;
    protected int getNrDoors() {
        return nrDoors;
    }
    protected int getDirection(){
        return direction;
    }
    protected double getEnginePower() {
        return enginePower;
    }
    protected double getY(){
        return y;
    }
    protected void setY(double kordinater) {
        y = kordinater;
    }
    protected void setX(double kordinater) {
        x = kordinater;
    }
    protected double getX(){
        return x;
    }
    protected double getCurrentSpeed() {
        return currentSpeed;
    }
    protected Color getColor() {
        return color;
    }

    protected void setColor(Color clr) {
        color = clr;
    }

    protected void startEngine() {
        currentSpeed = 0.1;
    }

    protected void stopEngine() {
        currentSpeed = 0;
    }


    protected void gas(double amount) {
        if (0 <= amount && amount <= 1) {
             incrementSpeed(amount);
    }
        }

    protected abstract double speedFactor();


    protected void brake(double amount) {
        if (0 <= amount && amount <= 1) {
        decrementSpeed(amount);
        }
        }
    protected double getCarLength() {
        return carLength;
    }

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + this.speedFactor() * amount, enginePower);
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - this.speedFactor() * amount, 0);
    }

    public void move() {
        if (direction == 0) {
            y += currentSpeed;
        } else if (direction == 1) {
            x += currentSpeed;
        } else if (direction == 2) {
            y -= currentSpeed;
        } else if (direction == 3) {
            x -= currentSpeed;
        }
    }

    public void turnLeft() {
        direction = (direction +3) %4;
    }

    public void turnRight() {
        direction = (direction +1) %4;
    }
}



