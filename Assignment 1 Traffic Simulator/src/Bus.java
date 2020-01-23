import java.awt.Color;
import java.awt.Graphics;

public class Bus extends Vehicle{

    private Color lightGreen = new Color(102,255,102); // the rgb color for the bus

    /**Instantiate the Bus class**/
    public Bus(int x_axis, int y_axis) {
        super(x_axis, y_axis); // x_axis and y_axis from the vehicle class
        vehicle_speed = 7; // set the speed of the bus
        vehicle_height = 10; // set the height of the bus
        vehicle_width = 45; // set the width of the bus
    }

    /**Control the Bus display**/
    public void paintMe(Graphics graphics) {
        graphics.setColor(lightGreen); // set the bus color
        graphics.fillRect(x_axis, y_axis, vehicle_width, vehicle_height); // set the position and size of the bus
    }

}
