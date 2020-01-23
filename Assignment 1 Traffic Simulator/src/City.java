import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class City extends JPanel {
    final int roadHeight = 300; // the size of the road
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(); // array list that contain vehicles
    ArrayList<Signal> trafficLights = new ArrayList<Signal>(); // array list that contain traffic lights

    private Color darkPink = new Color(144,55,73); // create color
    private Color darkBrown = new Color(83,53,74); // create color

    /**
     Instantiate City class
     **/
    public City() {
        setBackground(darkBrown);
        setForeground(darkBrown);
        setBounds(187, 0, 855, 590);
        setLayout(null);
        setVisible(true);
    }

