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

		/**Display**/
		public void paintMe(Graphics graphics) {
			
		}

		/**Set the vehicle position**/
		public void setVehicle_position(int p) {
			this.vehicle_position = p;
		}

		/**Get the X position**/
		public int getX_axis() {
			return x_axis;
		}

		/**Set the X position**/
		public void setX_axis(int x_axis) {
			this.x_axis = x_axis;
		}

		/**Get the Y position**/
		public int getY_axis() {
			return y_axis;
		}

		/**Set the Y position**/
		public void setY_axis(int y_axis) {
			this.y_axis = y_axis;
		}

		/**Get the Vehicle Speed**/
		public int getVehicle_speed() {
			return vehicle_speed;
		}

		/**Set the Vehicle Speed**/
		public void setVehicle_speed(int vehicle_speed) {
			this.vehicle_speed = vehicle_speed;
		}

		/**Get the Vehicle Width**/
		public int getVehicle_width() {
			return vehicle_width;
		}

		/**Set the Vehicle Width**/
		public void setVehicle_width(int vehicle_width) {
			this.vehicle_width = vehicle_width;
		}

		/**Get the Vehicle Height**/
		public int getVehicle_height() {
			return vehicle_height;
		}

		/**Set the Vehicle Height**/
		public void setVehicle_height(int vehicle_height) {
			this.vehicle_height = vehicle_height;
		}

		/**Set the road position**/
		public void setRoad(int x,int y) {
			if(x >= -40 & x <= 305 & y == 104 || y == 135 & x >= 0 & x <= 310) {
				this.road = "r1";
				this.signal = "s1";
				this.current = false;
				this.previous = this.road;
				if(x <- 20) {
					check = true;
				}
				
			}
			else if(y >= 0 & y <= 55 & x == 354 || x == 385 & y >- 30 & y <= 60) {
				this.road = "r2";
				this.signal = "s2";
				this.current = false;
				this.previous = this.road;
				if(y<-20) {
					check = true;
				}
				
			}
			else if(y <= 370 & y >= 165 & x == 385 ||x == 354 & y <= 355 & y >= 150) {
				this.road = "r3";
				this.signal = "s3";
				this.current = false;
				this.previous = this.road;
			}
			else if(x >= 409 & x <= 820 & y == 135 || x >= 390 & x <= 890 & y == 104) {
				this.road = "r4";
				this.signal = "s4";
				this.current = false;
				this.previous = this.road;
				if(x > 870) {
					check = true;
				}
				
			}
			else if(y <= 560 & y >= 465 & x == 185 || x == 155 & y <= 560 & y >= 445) {
				this.road = "r5";
				this.signal = "s5";
				this.current = false;
				this.previous = this.road;
			}
			else if(y <= 560 & y >= 465 & x == 385 || y <= 560 & y >= 445 & x == 355 ) {
				this.road = "r6";
				this.signal = "s6";
				this.current = false;
				this.previous = this.road;
			}
			else if(y <= 560 & y >= 465 & x == 685 || y <= 560 & y >= 445 & x == 655) {
				this.road = "r7";
				this.signal = "s7";
				this.current = false;
				this.previous = this.road;
			}
			else if(x >= 0 & x <= 820 & y == 404 || x >= 0 & x <= 850 & y == 432 ) {
				this.road = "main";
				this.previous = this.road;
				this.signal = "main";
				if(this.x_axis > 780) {
					this.check = true;
				}
			}
			else {
				
				this.road = "in";
				if(this.num3 >=3) {
					this.current = true;
				if(this.num >=3) {
					if(this.previous.equals("r1")) {
						this.y_axis =59;
						this.x_axis =385;
						turn2();
						this.turn1=false;
						this.turn3=false;
						this.road="r2";
						this.previous=this.road;
						num =0;
						
						
					}
					else if(this.previous.equals("r2")) {
						if(num ==3 & num1 ==0) {
							this.turn2=false;
							this.turn1=false;
							this.turn3=false;
							this.road="in";
							turn();
							num =0;
							
						}
						if(num1 ==1) {
							this.y_axis =104;
							this.x_axis =392;
							this.road="r4";
							num1 =0;
							this.previous=this.road;
							
						}
						num1++;
						
					}
					else if(this.road.equals("r3")) {
					
					}
					else if(this.road.equals("r4")) {
					}
					else if(this.previous.equals("r5")) {

						this.y_axis =404;
						this.x_axis =190;
						this.turn2=false;
						this.turn1=false;
						this.turn3=false;
						this.road="main";
						num =0;
						turn();
					}
					else if(this.previous.equals("r6")) {
						this.y_axis =404;
						this.x_axis =390;
						this.turn2=false;
						this.turn1=false;
						this.turn3=false;
						this.road="main";
						num =0;
						turn();
					}
					else if(this.previous.equals("r7")) {
						this.y_axis =404;
						this.x_axis =690;
						this.turn2=false;
						this.turn1=false;
						this.turn3=false;
						this.road="main";
						num =0;
						turn();
						
					}
				}
				num++;
			}
				this.num3++;}
		}

		/**The display when Vehicle turn**/
		public void turn() {
			int turned = this.vehicle_width;
			this.vehicle_width =this.vehicle_height;
			this.vehicle_height = turned;
		}

		/**First Turn Situation**/
		public void turn1() {
			if(this.turn1==false) {
			int turned2 = 0;
			turned2 = this.vehicle_height;
			this.vehicle_height =this.vehicle_width;
			this.vehicle_width =turned2;
			this.turn1=true;
			
			}
			else {
				int turned3 = 0;
				turned3 = this.vehicle_height;
				this.vehicle_height =this.vehicle_width;
				this.vehicle_width =turned3;
				this.turn1=false;
			}
		}

		/**Second Turn Situation**/
		public void turn2() {
			if(this.turn2==false) {
			int turned_4 = 0;
			turned_4 = this.vehicle_height;
			this.vehicle_height =this.vehicle_width;
			this.vehicle_width =turned_4;
			this.turn2=true;
			
			}
			else {
				int turned5=0;
				turned5=this.vehicle_height;
				this.vehicle_height =this.vehicle_width;
				this.vehicle_width =turned5;
				this.turn2=false;
			}
		}

		/**Third Turn Situation**/
		public void turn3() {
			if(this.turn3==false) {
				this.turn3=true;
			
			}
			else {
				this.turn3=false;
			}
		}
	}

