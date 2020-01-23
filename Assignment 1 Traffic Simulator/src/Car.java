import java.awt.Color;
import java.awt.Graphics;

public class Car extends Vehicle{

	private Color tosca = new Color(102,255,255); // the rgb color for the bus

	/**Instantiate the Car class**/
	public Car(int x_axis, int y_axis) {
		super(x_axis, y_axis); // x_axis and y_axis from the vehicle class
		vehicle_speed = 15; // set the speed of the car
		vehicle_height = 10; // set the height of the car
		vehicle_width = 30; // set the width of the car
	}

	/**Control the Car display**/
	public void paintMe(Graphics graphics) {
		graphics.setColor(tosca); // set the color of the car
		graphics.fillRect(x_axis, y_axis, vehicle_width, vehicle_height); // set the position and the size of the car
	}

	/**Set the speed of the Car**/
	public void setRate(int r) {
		this.vehicle_speed =r;
	}
	

}
