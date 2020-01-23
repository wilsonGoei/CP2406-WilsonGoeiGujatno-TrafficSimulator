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

    /**Add Vehicle Method**/
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle); // Add vehicle to array list
    }

    /**Add Traffic lights Method**/
    public void addSignal(Signal signal) {
        trafficLights.add(signal); // add traffic light to array list

    }

    /**Set the Traffic Light status**/
    public void setSignal(int i,boolean r,boolean y,boolean g) {
        trafficLights.get(i).setSignal(r, y, g);
    }

    /**Control the Display**/
    public void paint(Graphics graphics) {

        super.paintComponent(graphics);

        if(roads<=2) {

            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(0, 100, 870, 50); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    graphics.fillRect(b, 120, 30, 5); // customize the position and size of the stripes
                }
            }
        }

//R2 and R3
        else if(roads<=4) {

            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(0, 100, 870, 50); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    graphics.fillRect(b, 120, 30, 5); // customize the position and size of the stripes
                }
            }
            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(350, 0, 50, 600); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=0;b<getHeight();b+=40) {
                    graphics.fillRect(375, b, 5, 30); // customize the position and size of the stripes
                }
            }}


        else if(roads<=6) {
            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(0, 100, 870, 50); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    graphics.fillRect(b, 120, 30, 5); // customize the position and size of the stripes
                }
            }
            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(350, 0, 50, 600); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=0;b<getHeight();b+=40) {
                    graphics.fillRect(375, b, 5, 30); // customize the position and size of the stripes
                }
            }
            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(0, 400, 870, 50); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    graphics.fillRect(b, 420, 30, 5); // customize the position and size of the stripes
                }
            }
        }

        else if(roads<=10) {
            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(0, 100, 870, 50); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    graphics.fillRect(b, 120, 30, 5); // customize the position and size of the stripes
                }
            }
            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(350, 0, 50, 600); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=0;b<getHeight();b+=40) {
                    graphics.fillRect(375, b, 5, 30); // customize the position and size of the stripes
                }
            }
            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(0, 400, 870, 50); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=0;b<getWidth();b+=40) {
                    graphics.fillRect(b, 420, 30, 5); // customize the position and size of the stripes
                }
            }
            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(150, 400, 50, 600); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=430;b<getHeight();b+=40) {
                    graphics.fillRect(173, b, 5, 30); // customize the position and size of the stripes
                }
            }



            graphics.setColor(darkPink); // set the color of the roads
            graphics.fillRect(650, 400, 50, 600); // customize the position and size of the road

            graphics.setColor(Color.WHITE); // set the color of the stripes
            for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
                for(int b=430;b<getHeight();b+=40) {
                    graphics.fillRect(673, b, 5, 30); // customize the position and size of the stripes
                }
            }}


        for(int a = 0; a< trafficLights.size(); a++) {
            trafficLights.get(a).paintMe(graphics); // display the traffic lights
        }

        for(int a = 0; a< vehicles.size(); a++) {
            vehicles.get(a).paintMe(graphics); // display the vehicles
        }
    }

