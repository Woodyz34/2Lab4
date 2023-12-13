import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class DrawPanel extends JPanel {
    private static DrawPanel instance;

    private DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.cyan);
    }
    public static DrawPanel getInstance() {
        if (instance == null) {
            instance = new DrawPanel(800,800-240);
        }
        return instance;
    }


    // The controller member
    protected JPanel controlPanel = new JPanel();
    protected JPanel gasPanel = new JPanel();
    protected JSpinner gasSpinner = new JSpinner();
    protected int gasAmount = 0;
    protected JLabel gasLabel = new JLabel("Amount of gas");
    protected JButton gasButton = new JButton("Gas");
    protected JButton brakeButton = new JButton("Brake");
    protected JButton turboOnButton = new JButton("Saab Turbo on");
    protected JButton turboOffButton = new JButton("Saab Turbo off");
    protected JButton liftBedButton = new JButton("Scania Lift Bed");
    protected JButton lowerBedButton = new JButton("Lower Lift Bed");
    protected JButton startButton = new JButton("Start all cars");
    protected JButton stopButton = new JButton("Stop all cars");
    JButton addCarButton = new JButton("Add");
    JButton removeCarButton = new JButton("Remove");
    // Constructor

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work


        protected CarInWorld carWorld = CarInWorld.getInstance();
        BufferedImage carImage;

    public DrawPanel() {

    }
    private static final int X = 800;
    public void getButton(){
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        controlPanel.setLayout(new GridLayout(2, 4));
        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        controlPanel.setBackground(Color.CYAN);
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        controlPanel.add(addCarButton, 3);
        controlPanel.add(removeCarButton, 7);
    }

    @Override
        protected void paintComponent (Graphics g){
            super.paintComponent(g);
        if (carWorld.cars.size()==1) {
            repaint();
        }
            for (Cars car : carWorld.cars) {
                try {
                    carImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + car.modelName + ".jpg"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                g.drawImage(carImage, (int) car.getX(), (int) car.getY(), null);

            }
        }
    }


