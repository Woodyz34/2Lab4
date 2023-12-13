import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarGame {
    CarInWorld carWorld = CarInWorld.getInstance();
    private final int delay = 10;
    private Timer timer = new Timer(delay, new TimerListener());
    private Controller frame;
    DrawPanel drawPanel = DrawPanel.getInstance();

    public static void main(String[] args) {
        // Instance of this class
        CarGame cg = new CarGame();
        CarMethods cm = new CarMethods();

        // Start a new view and send a reference of self
        cg.frame = new Controller("CarSim 1.0", cm);


        // Start the timer
        cg.timer.start();
    }

    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Cars car : carWorld.cars) {
                drawPanel.repaint();
                car.move();
                carWorld.CheckCarInWindow();
            }
        }
    }
}