import java.awt.Color;
import java.awt.Graphics;


public class Bike extends Vehicle{

    /**Instantiate the Bike class**/
    public Bike(int x_axis, int y_axis) {
        super(x_axis, y_axis); // x_axis and y_axis from the vehicle class
        vehicle_speed =20; // speed of the bike
        vehicle_height =10; // height of the bike
        vehicle_width =15; // width of the bike
    }

    /**Control the bike display**/
    public void paintMe(Graphics graphics) {
        graphics.setColor(Color.YELLOW); // set the bike color to yellow
        graphics.fillRect(x_axis, y_axis, vehicle_width, vehicle_height); // set the bike size and position
    }


}
