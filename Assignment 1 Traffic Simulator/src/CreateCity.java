import java.awt.Color;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.util.ArrayList;

public class CreateCity extends JPanel {

    /**
     * Create the panel.
     */
    int roads = 0; // number of roads
    String name=""; // name of the city
    int roadHeight =300; // road height
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(); // contain vehicles
    ArrayList<Signal> trafficLights = new ArrayList<Signal>(); // contain traffic lights
    private Color darkPink = new Color(144,55,73); // dark pink color for road color
    private Color darkBrown = new Color(83,53,74); // dark brown color for the map background

    /**Instantiate Create City class**/
    public CreateCity(String name,int roads) {
        setBackground(darkBrown); // set the map background to dark brown
        setForeground(darkBrown);
        setBounds(187, 0, 855, 590); // set the size of the map/city
        setLayout(null);
        setVisible(true); // set the map/city to visible
        this.name = name; // name of the city
        this.roads = roads; // number of roads
    }

