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

