import java.awt.*;

public class Vehicle {
    int x_axis; // x position
    int y_axis; // y position
    int vehicle_speed; // the vehicle speed
    int vehicle_width; // the vehicle width
    int vehicle_height; // the vehicle height
    int vehicle_position = 0; // the vehicle position
    String signal = ""; // traffic lights
    String road; // road
    int num = 0;
    int num1 = 0;
    int num3;
    boolean current = false;
    boolean turn1 = false; // whether the vehicle turn or not
    boolean turn2 = false; // whether the vehicle turn or not
    boolean turn3 = false; // whether the vehicle turn or not
    boolean check = false;

    String previous;

    /**Instantiate the Vehicle class**/
    public Vehicle(int x_axis, int y_axis) {

        this.x_axis = x_axis; // x axis of the vehicle
        this.y_axis = y_axis; // y axis of the vehicle
        this.num3 = 0;
        if(x_axis >= 0 & x_axis <= 305 & y_axis == 104 || y_axis == 135 & x_axis >= 0 & x_axis <=310) {
            this.road = "r1";
            this.signal = "s1";


        }
        else if(y_axis >=0 & y_axis <=55 & x_axis ==354 || x_axis ==385 & y_axis >=0 & y_axis <=60) {
            this.road="r2";
            this.signal="s2";



        }
        else if(y_axis <=370 & y_axis >=165 & x_axis ==385 || x_axis ==354 & y_axis <=365 & y_axis >=150) {
            this.road="r3";
            this.signal="s3";


        }
        else if(x_axis >=395 & x_axis <=820 & y_axis ==135 || x_axis >=395 & x_axis <=820 & y_axis ==104) {
            this.road="r4";
            this.signal="s4";


        }
        else if(y_axis <=580 & y_axis >=445 & x_axis ==185 || x_axis ==155 & y_axis <=580 & y_axis >=445) {
            this.road="r5";
            this.signal="s5";

        }
        else if(y_axis <=580 & y_axis >=445 & x_axis ==385 || y_axis <=580 & y_axis >=445 & x_axis ==355 ) {
            this.road="r6";
            this.signal="s6";


        }
        else if(y_axis <=580 & y_axis >=445 & x_axis ==685 || y_axis <=580 & y_axis >=445 & x_axis ==655) {
            this.road="r7";
            this.signal="s7";


        }
        else if(x_axis >=0 & x_axis <=820 & y_axis ==404 || x_axis >=0 & x_axis <=820 & y_axis ==432 ) {
            this.road="main";
            this.signal="main";


        }

    }