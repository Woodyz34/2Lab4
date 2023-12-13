import javax.swing.*;
import java.awt.*;

public class InitComponents extends JFrame{
    DrawPanel drawPanel = DrawPanel.getInstance();
    private static final int X = 800;
    private static final int Y = 800;
    protected void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
        drawPanel.getButton();
        // Eftersom vi både är beroende på att extenda JFrame och JPanel krävs det att InitComponents kallar på drawPanel till viss del.
        this.add(drawPanel.gasPanel);

        this.add(drawPanel.controlPanel);

        this.add(drawPanel.startButton);

        this.add(drawPanel.stopButton);

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary

        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
