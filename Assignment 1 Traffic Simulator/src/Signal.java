import java.awt.Color;
import java.awt.Graphics;

public class Signal {
	private int x_axis = 0; // x of the traffic lights
	private int y_axis = 0; // y of the traffic lights
	private boolean red = false; // red light status
	private boolean yellow = false; // yellow light status
	private boolean turn = false; // traffic light
	boolean green = false; // green light status

	/**Instantiate Signal class**/
	public Signal(boolean red, boolean yellow, boolean green, int x_axis, int y_axis, boolean turn) {
		this.red = red;
		this.yellow = yellow;
		this.green = green;
		this.x_axis = x_axis;
		this.y_axis = y_axis;
		this.turn = turn;
	}

	/**Set the status of the traffic lights**/
	public void setSignal(boolean red_input, boolean yellow_input, boolean green_input) {
		this.red = red_input; // set the red light
		this.yellow = yellow_input; // set the yellow light
		this.green = green_input; // set the green light
	}

	/**Control the display of the traffic lights**/
	public void paintMe(Graphics graphics) {
		if(turn == false) {
			graphics.setColor(Color.BLACK); // the color become black
			graphics.fillRect(x_axis, y_axis, 10, 40); // draw the traffic light

			if(this.red==true) {
				graphics.setColor(Color.RED); // turn on the red light
				graphics.fillOval(x_axis +1, y_axis +10, 8, 8); // set the position and size of the red light
				
				}
			else if(this.yellow==true) {
				graphics.setColor(Color.YELLOW); // turn on the yellow light
				graphics.fillOval(x_axis +1, y_axis +10, 8, 8); // set the position and size of the yellow light
				}
			else {
				graphics.setColor(Color.GREEN); // turn on the green light
				graphics.fillOval(x_axis +1, y_axis +10, 8, 8); // set the position and size of the green light
				}
			}
		else {
			graphics.setColor(Color.BLACK); // make the traffic light color black
			graphics.fillRect(x_axis, y_axis, 40, 10); // create the traffic light
			if(this.red==true) {
				graphics.setColor(Color.RED); // turn on the red light
				graphics.fillOval(x_axis +10, y_axis +1, 8, 8); // set the position and size of the red light
				}
			else if(this.yellow==true) {
				graphics.setColor(Color.YELLOW); // turn on the yellow light
				graphics.fillOval(x_axis +10, y_axis +1, 8, 8); // set the position and size of the yellow light
				}
			else {
				graphics.setColor(Color.GREEN); // turn on the green light
				graphics.fillOval(this.x_axis +10, this.y_axis +1, 8, 8); // set the position and size of the green light
			}
			
		}
	}
}
