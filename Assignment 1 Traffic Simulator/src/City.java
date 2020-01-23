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

	/**Add the traffic light method**/
	public void addSignal(Signal signal) {
		trafficLights.add(signal);

	}

	/**Add the vehicle method**/
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	/**Set the traffic lights**/
	public void setSignal(int i,boolean r,boolean y,boolean g) {
		trafficLights.get(i).setSignal(r, y, g); //set the traffic lights
	}

	/**The display of the city**/
	public void paint(Graphics graphics) {

		super.paintComponent(graphics);

		
		graphics.setColor(darkPink); // color of the road
		graphics.fillRect(350, 0, 50, 600); // size and position of the road
		
		graphics.setColor(Color.WHITE); // color of the stripes
		for(int a = roadHeight; a < roadHeight *4; a = a + roadHeight) {
			for(int b=0;b<getHeight();b+=40) {
				graphics.fillRect(375, b, 5, 30); // size and position of the stripes
			}
		}
		
		
		
		
		graphics.setColor(darkPink); // color of the road
		graphics.fillRect(0, 100, 870, 50); // size and position of the road
		
		graphics.setColor(Color.WHITE); // color of the stripes
		for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
			for(int b=0;b<getWidth();b+=40) {
				graphics.fillRect(b, 120, 30, 5); // size and position of the road
			}
		}
		
		
		
		graphics.setColor(darkPink); // color of the road
		graphics.fillRect(0, 400, 870, 50); // size and position of the road
		
		graphics.setColor(Color.WHITE); // color of the stripes
		for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
			for(int b=0;b<getWidth();b+=40) {
				graphics.fillRect(b, 420, 30, 5); // size and position of the road
			}
		}
		
		
		graphics.setColor(darkPink); // color of the road
		graphics.fillRect(150, 400, 50, 600); // size and position of the road
		
		graphics.setColor(Color.WHITE); // color of the stripes
		for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
			for(int b=430;b<getHeight();b+=40) {
				graphics.fillRect(173, b, 5, 30); // size and position of the road
			}
		}
		
		
		
		graphics.setColor(darkPink); // color of the road
		graphics.fillRect(650, 400, 50, 600); // size and position of the road
		
		graphics.setColor(Color.WHITE); // color of the stripes
		for(int a = roadHeight; a< roadHeight *4; a=a+ roadHeight) {
			for(int b=430;b<getHeight();b+=40) {
				graphics.fillRect(673, b, 5, 30); // size and position of the stripes
			}
		}

		
		
		
		for(int a = 0; a< vehicles.size(); a++) {
			vehicles.get(a).paintMe(graphics); // display the vehicles
		}
		for(int a = 0; a< trafficLights.size(); a++) {
			trafficLights.get(a).paintMe(graphics); // display the traffic lights
		}
		
	}

	/**Control the steps of the simulator**/
	public void step() {
		for(int i = 0; i< vehicles.size(); i++) {
			Vehicle vehicle= vehicles.get(i);
			
			
			if(vehicle.turn1==true & !vehicle.road.equals("in") ) {
				vehicle.setY_axis(vehicle.getY_axis()+vehicle.getVehicle_speed() );
				vehicle.setVehicle_position(vehicle.getY_axis()+vehicle.getVehicle_speed());
				vehicle.setRoad(vehicle.getX_axis(), vehicle.getY_axis());
				
				
				
			}
			else if(vehicle.turn2==true & !vehicle.road.equals("in")){
				vehicle.setY_axis(vehicle.getY_axis()-vehicle.getVehicle_speed());
				vehicle.setVehicle_position(vehicle.getY_axis()-vehicle.getVehicle_speed());
				vehicle.setRoad(vehicle.getX_axis(), vehicle.getY_axis());
			
				
				}
			else if(vehicle.turn3==true & !vehicle.road.equals("in")){
				vehicle.setX_axis(vehicle.getX_axis()-vehicle.getVehicle_speed());
				vehicle.setVehicle_position(vehicle.getX_axis()-vehicle.getVehicle_speed());
				vehicle.setRoad(vehicle.getX_axis(), vehicle.getY_axis());
				
			
			}
			else if(vehicle.turn3==false & vehicle.turn3==false & vehicle.turn3==false & !vehicle.road.equals("in")) {
				vehicle.setX_axis(vehicle.getX_axis()+vehicle.getVehicle_speed());
				vehicle.setVehicle_position(vehicle.getX_axis()+vehicle.getVehicle_speed());
				vehicle.setRoad(vehicle.getX_axis(), vehicle.getY_axis());
				
			
			}
			else {
				if(vehicle.current==true) {
					
					int count=0;
					if(vehicle.signal.equals("s1")) {count=0;}
					else if(vehicle.signal.equals("s2")) {count=1;}
					else if(vehicle.signal.equals("s3")) {count=2;}
					else if(vehicle.signal.equals("s4")) {count=3;}
					else if(vehicle.signal.equals("s5")) {count=4;}
					else if(vehicle.signal.equals("s6")) {count=5;}
					else if(vehicle.signal.equals("s7")) {count=6;}
					else if(vehicle.signal.equals("s8")) {count=7;}
					
					if(count==0) {
						trafficLights.get(count).setSignal(false, false, true);
						
					}
					else {
						trafficLights.get(count-1).setSignal(true, false, false);
						trafficLights.get(count).setSignal(false, false, true);
					}
					if(vehicle.turn1==true) {
						vehicle.setY_axis(vehicle.getY_axis()+vehicle.getVehicle_speed() );
						vehicle.setRoad(vehicle.getX_axis(), vehicle.getY_axis());
					}
					else if(vehicle.turn2==true){
						vehicle.setY_axis(vehicle.getY_axis()-vehicle.getVehicle_speed());
						
						vehicle.setRoad(vehicle.getX_axis(), vehicle.getY_axis());
					
						
						}
					else if(vehicle.turn3==true ){
						vehicle.setX_axis(vehicle.getX_axis()-vehicle.getVehicle_speed());
						vehicle.setRoad(vehicle.getX_axis(), vehicle.getY_axis());
						
					
					}
					else if(vehicle.turn3==false & vehicle.turn3==false & vehicle.turn3==false ) {
						vehicle.setX_axis(vehicle.getX_axis()+vehicle.getVehicle_speed());
						vehicle.setRoad(vehicle.getX_axis(), vehicle.getY_axis());
						
					
					}
				}
				else {
					vehicle.setRoad(vehicle.getX_axis(), vehicle.getY_axis());
				}
				
			}	
		}
		}

	}

	


