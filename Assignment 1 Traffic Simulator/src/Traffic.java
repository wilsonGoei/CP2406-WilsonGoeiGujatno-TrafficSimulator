import javafx.scene.media.MediaPlayer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.media.Media;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Traffic extends JFrame implements Runnable,ActionListener {
	private Vehicle vehicles[]=new Vehicle[30];  //Create array that will contain the vehicle
	private CreateCity createdCities[]=new CreateCity[5]; // Array that contain cities
	int cityNum =0; // Variable that keep track the number of the city
	private City city =new City(); // Instansiate City class
	private Signal signal; // Instansiate Traffic Light
	private JPanel contentPanel; // Panel that contains the graphics
	private boolean simulationRunning =false; // Boolean if the simulation running or not
	boolean open =false; // Boolean to keep track if map is opened from the saved map
	int indexNumber =0; // index number
	int anotherIndex =0; // another index number
	private JLabel vehicleNumLabel =new JLabel(""); // Blank label that will be changed later
	JButton buttonRun = new JButton("RUN\r\n"); // Create Run button
	JButton buttonStop = new JButton("STOP"); // Create Stop Button
	int counter =0; // counter
	private int total=0; // Keep track of the total vehicle
	private Color darkBlue = new Color(43,46,74); // Blue color for the background
	private int updateRateNum;
	private JLabel updateRateNumStat = new JLabel("1"); // set the update rate num to 1


	/**
	 * Create the frame.
	 */
	public Traffic() {
		setTitle("Traffic Simulator by Wilson Goei Gujatno"); // Set title Frame
		setVisible(true); // Make the Frame visible
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close when the X button pressed
		setBounds(100, 100, 1058, 629); // Fixed size for the program
		contentPanel = new JPanel(); // Instantiate the Panel for menu
		contentPanel.setBackground(darkBlue); // Set the menu background
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Set the border for the menu
		setContentPane(contentPanel); // set the content pane
		contentPanel.setLayout(null); // set layout
		contentPanel.add(city); // add city to the panel
		

		
		addSignal(-10,0); // add traffic to certain position
		buttonStop.setFont(new Font("ROG Fonts", Font.BOLD, 25)); // configure the font for stop button
		buttonStop.setBounds(20, 250, 130, 23); // set the size and the position for the stop button
		buttonStop.addActionListener(this); // set action listener for stop button
		contentPanel.add(buttonStop); // add the stop button in the menu panel

		
		
		buttonRun.setFont(new Font("ROG Fonts", Font.BOLD, 25)); // configure the font for run button
		buttonRun.setBounds(20, 200, 130, 23); // set the size and the position for the stop button
		buttonRun.addActionListener(this); // set action listener for stop button
		contentPanel.add(buttonRun); // add the stop button in the menu panel
		
		JButton setUpdateRate = new JButton("SET UPDATE RATE\r\n"); // create button to set update rate
		setUpdateRate.setFont(new Font("ROG Fonts", Font.BOLD, 12)); // configure font for the set update rate button
		setUpdateRate.setBounds(1,300,185,23); // set the size and the position for the set update rate button
		setUpdateRate.setVisible(true); // set the button to visible
		contentPanel.add(setUpdateRate); // add the set update rate button to menu panel

		
		JButton buttonOpen = new JButton("OPEN\r\n"); // create open button
		buttonOpen.setFont(new Font("ROG Fonts", Font.BOLD, 15)); // configure the font for open button
		buttonOpen.setBounds(20, 280, 130, 23); // set the size and the position for the stop button
		buttonOpen.setVisible(false); // set the button visibility to false in simulator mode
		contentPanel.add(buttonOpen); // add the open button to menu panel
		
		JButton buttonEdit = new JButton("EDIT"); // create edit button
		buttonEdit.setFont(new Font("ROG Fonts", Font.BOLD, 15)); // configure the font for edit button
		buttonEdit.setBounds(20, 240, 130, 23); // set the size and the position for the edit button
		buttonEdit.setVisible(false); // set the button visibility to false in simulator mode
		contentPanel.add(buttonEdit); // add the edit button to menu panel
		
		JButton buttonNewButton_2 = new JButton("CREATE"); // create create button
		buttonNewButton_2.setFont(new Font("ROG Fonts", Font.BOLD, 15)); // configure the font for create button
		buttonNewButton_2.setBounds(20, 200, 130, 23); // set the size and the position for the create button
		contentPanel.add(buttonNewButton_2); // add the create button to menu panel
		
		JLabel labelMenu = new JLabel("MENU"); // create title for menu
		labelMenu.setBounds(15, 15, 150, 35); // configure the font for menu label
		labelMenu.setFont(new Font("ROG Fonts", Font.BOLD, 40)); // set the size and the position for the menu label
		labelMenu.setForeground(Color.WHITE); // set the color of the label
		contentPanel.add(labelMenu); // add the menu label
		
		JButton buttonButtonEditCity = new JButton("CITY EDIT\r\n"); // create city edit button
		buttonButtonEditCity.setBounds(0, 81, 190, 23); // set the size and the position for the city edit button
		buttonButtonEditCity.setFont(new Font("ROG Fonts", Font.BOLD, 20)); // configure the font for city edit button
		contentPanel.add(buttonButtonEditCity); // add the city edit button to menu panel
		
		JButton buttonNewButtonSim = new JButton("SIMULATOR"); // create simulator button
		buttonNewButtonSim.setBounds(0, 130, 190, 23); // set the size and the position for the simulator button
		buttonNewButtonSim.setFont(new Font("ROG Fonts", Font.BOLD, 20)); // configure the font for simulator button
		contentPanel.add(buttonNewButtonSim); // add the simulator button to menu panel
		
		JLabel labelMode = new JLabel("Mode:Simulator"); // create mode label
		labelMode.setForeground(Color.WHITE); // change the color of the label
		labelMode.setFont(new Font("ROG Fonts", Font.BOLD, 16)); // configure the font for mode label
		labelMode.setBounds(0, 388, 200, 23); // set the size and the position for the model label
		contentPanel.add(labelMode); // add the mode label to the menu panel
		
		JLabel labelStatus = new JLabel("Status:"); // create status label
		labelStatus.setForeground(Color.WHITE); // change the color of the label
		labelStatus.setFont(new Font("ROG Fonts", Font.BOLD, 20)); // configure the font for status label
		labelStatus.setBounds(0, 432, 200, 23); // set the size and the position for the model label
		contentPanel.add(labelStatus); // add the mode label to the menu panel
		
		JLabel labelCityDefault = new JLabel("City: Default"); // create the label for active city
		labelCityDefault.setForeground(Color.WHITE); // change the color of the label
		labelCityDefault.setFont(new Font("ROG Fonts", Font.BOLD, 16)); // configure the font for active city label
		labelCityDefault.setBounds(10, 466, 200, 23); // set the size and the position for the active city label
		contentPanel.add(labelCityDefault); // add the active city label to the menu panel
		
		JLabel labelVehicles = new JLabel("Vehicles:"); // create the label for vehicle number
		labelVehicles.setForeground(Color.WHITE); // change the color of the label
		labelVehicles.setFont(new Font("ROG Fonts", Font.BOLD, 16)); // configure the font for vehicle number label
		labelVehicles.setBounds(10, 500, 110, 23); // set the size and the position for the vehicle number label
		contentPanel.add(labelVehicles); // add the vehicle number label to the menu panel
		
		vehicleNumLabel.setText(String.valueOf(total)); // set number of vehicle
		vehicleNumLabel.setForeground(Color.WHITE); // set the color to white
		vehicleNumLabel.setFont(new Font("ROG Fonts", Font.BOLD, 16)); // configure the text font
		vehicleNumLabel.setBounds(125, 500, 67, 23); // set the container position and size
		contentPanel.add(vehicleNumLabel); // add the label to the menu panel

		JLabel updateRateLabel = new JLabel("Update Rates:"); // create the label for update rate
		updateRateLabel.setForeground(Color.WHITE); // set the color to white
		updateRateLabel.setFont(new Font("ROG Fonts", Font.BOLD, 14)); // configure the font for update rate label
		updateRateLabel.setBounds(10,534,150,23); // set the size and the position of the update rate label
		contentPanel.add(updateRateLabel); // add the label to the menu panel

		updateRateNumStat.setForeground(Color.WHITE); // set the color to white
		updateRateNumStat.setFont(new Font("ROG Fonts", Font.BOLD, 16)); // configure the text font
		updateRateNumStat.setBounds(160, 534, 67, 23); // set the container position and size
		contentPanel.add(updateRateNumStat); // add the label to the menu panel

		/**Action listener for Simulator button**/
		buttonNewButtonSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				buttonRun.setVisible(true); // make run button visible
				buttonStop.setVisible(true); // make stop button visible
				setUpdateRate.setVisible(true); // make set update rate button to visible
				
				buttonOpen.setVisible(false); // make open button invisible
				buttonEdit.setVisible(false); // make edit button invisible
				buttonNewButton_2.setVisible(false); // make create button invisible
				labelMode.setText("MODE: SIMULATOR"); // make the model label to simulator
				labelCityDefault.setVisible(true); // make default mode label to visible
				labelVehicles.setVisible(true); // make label visible
				vehicleNumLabel.setVisible(true); // make label visible
				city.setVisible(true); // make label visible
				
			}
		});

		/**Action listener for Edit City button**/
		buttonButtonEditCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				buttonRun.setVisible(false); // make button invisible
				buttonStop.setVisible(false); // make button invisible
				setUpdateRate.setVisible(false); // make button invisible
			
				buttonOpen.setVisible(true); // make button visible
				buttonEdit.setVisible(true); // make button visible
				buttonNewButton_2.setVisible(true); // make button visible
				labelStatus.setVisible(false); // make label invisible
				labelMode.setText("MODE: CITY EDIT"); // make the mode label to city edit
				labelCityDefault.setVisible(false); // make label invisible
				labelVehicles.setVisible(false); // make label invisible
				vehicleNumLabel.setVisible(false); // make label invisible
			}
		});

		/**Action listener for Set Update Rate Button**/
		setUpdateRate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				JOptionPane optionPane = new JOptionPane(); // make option pane
				String updateRateNumInput = optionPane.showInputDialog("Enter the number of update rate:(1-5)"); // set update rate input
				updateRateNum = Integer.parseInt(updateRateNumInput); // change the input to Integer
				if (updateRateNum < 0 || updateRateNum > 5){
					optionPane.showMessageDialog(null,"Invalid Input","Error",JOptionPane.ERROR_MESSAGE); // error message
					updateRateNum = 1; // set the update rate number to 1
				}
				updateRateNumStat.setText(updateRateNumInput); // change the update rate status label
			}
		});

		/**Action listener for create button**/
		buttonNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cityNum <5) {
					city.setVisible(true); // make label visible
					buttonOpen.setVisible(false); // make button invisible
					buttonEdit.setVisible(false); // make button invisible
					buttonNewButton_2.setVisible(false); // make button invisible
					JOptionPane optionPane=new JOptionPane(); // make option pane
					String name=optionPane.showInputDialog("Enter city name"); // city name input
					int roads=Integer.parseInt(optionPane.showInputDialog("Enter no of Roads ")); // roads number input
				
					buttonRun.setVisible(false); // make button invisible
					buttonStop.setVisible(false); // make button invisible
				
					buttonOpen.setVisible(true); // make button visible
					buttonEdit.setVisible(true); // make button visible
					buttonNewButton_2.setVisible(true); // make button visible
					labelStatus.setVisible(false); // make button invisible
					labelMode.setText("MODE: CITY EDIT"); // change the mode label to city edit
					labelCityDefault.setVisible(false); // make label invisible
					labelVehicles.setVisible(false); // make label invisible
					vehicleNumLabel.setVisible(false); // make label invisible
					CreateCity create=new CreateCity(name,roads); //put the parameter to create city class
					createdCities[cityNum]=create; // put it to the list
					optionPane.showMessageDialog(contentPanel, "You have succesfully created "+name+".");
					city.setVisible(false); // make label invisible
					contentPanel.add(createdCities[cityNum]);
					for(int i = 0; i< cityNum; i++) {
						createdCities[i].setVisible(false);
					}
					addSignal(createdCities[cityNum].roads, cityNum);
					createdCities[cityNum].setVisible(true);
					cityNum++;
					
				}
				else {
					JOptionPane.showMessageDialog(contentPanel, "You can't create cities more than 5");
				}
				
				
			}
		});

		/**Action listener for edit button**/
		buttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonOpen.setVisible(false); // make button invisible
				buttonEdit.setVisible(false); // make button invisible
				buttonRun.setVisible(false); // make button invisible
				buttonStop.setVisible(false); // make button invisible
				buttonNewButton_2.setVisible(false); // make button invisible
				JOptionPane jOptionPane=new JOptionPane();
				if(cityNum !=0) {
				String name=jOptionPane.showInputDialog("Enter city name"); // enter city name that what to be opened
				int i=0;
				while(i!= cityNum) {
					if(createdCities[i].name.equalsIgnoreCase(name)) {
						int roads=Integer.parseInt(jOptionPane.showInputDialog("Enter no of Roads "));
						createdCities[i].roads=roads;
						JOptionPane.showMessageDialog(contentPanel, createdCities[i].name+" Edited succesfully!");
						for(int m = 0; m< cityNum; m++) {
							createdCities[m].setVisible(false);
						}
						createdCities[i].trafficLights.clear();
						addSignal(roads,i);	
						createdCities[i].setVisible(true);
					}
					i++;
				}
				
				}
				else {
					JOptionPane.showMessageDialog(contentPanel, "No Cities Found!"); // if the city not found
					
				}
				buttonOpen.setVisible(true); // make button visible
				buttonEdit.setVisible(true); // make button visible
				buttonNewButton_2.setVisible(true); // make button visible
			}
			
		});

		/**Action listener for open button**/
		buttonOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cityNum >0) {
					String name=JOptionPane.showInputDialog("Enter city name"); // prompt to get the city name
					for(int i = 0; i< cityNum; i++) {
						
						if(createdCities[i].name.equalsIgnoreCase(name)) { // if the city name is same with the stored city
							
							open=true; // open the city
							indexNumber = createdCities[i].roads;
							i=i;
							createdCities[i].setVisible(true); // make the opened city visible
							buttonRun.setVisible(true); // make the run button visible
							buttonStop.setVisible(true); // make the stop button invisible
							setUpdateRate.setVisible(true); // make the set update rate visible
							
							buttonOpen.setVisible(false); // make the open button invisible
							buttonEdit.setVisible(false); // make the edit button invisible
							buttonNewButton_2.setVisible(false); // make the create button invisible
							labelMode.setText("MODE: SIMULATOR"); // change the mode to simulator
							labelCityDefault.setText("City:"+ createdCities[i].name); // change the city label name
							labelCityDefault.setVisible(true); // set the label to visible
							labelVehicles.setVisible(true); // set the vehicle label to visible
							vehicleNumLabel.setVisible(true); // set the vehicle number label to visible
							total=0; // set the total to 0
							
											}
					}
					
				}
				else {
					JOptionPane.showMessageDialog(contentPanel, "No Cities Found!"); // if there is no city name input same with the stored city
				}
			}
		});
		
	}

	/**Check the vehicles**/
	public void check() {
		for(int j=0;j<total;j++) {

			if(vehicles[j].check==true) {
				for(int k=j;k<total;k++) {
					vehicles[k]= vehicles[k+1];
				}
				total--;
				
			}
			
		}
	}

	/**Control the position of the traffic lights**/
	public void addSignal(int index,int i) {
		if(index>0 & index<=2) {
		}
		else if(index>2 & index<=4) {
			createdCities[i].addSignal(new Signal(true,false,false,310, 117,true)); // add traffic light to a particular city
			createdCities[i].addSignal(new Signal(true,false,false,372, 60,false)); // add traffic light to a particular city
			createdCities[i].addSignal(new Signal(true,false,false,372, 150,false)); // add traffic light to a particular city
			createdCities[i].addSignal(new Signal(true,false,false,395, 117,true)); // add traffic light to a particular city
		}
		else if(index>4 & index<=6) {
			createdCities[i].addSignal(new Signal(true,false,false,310, 117,true)); // add traffic light to a particular city
			createdCities[i].addSignal(new Signal(true,false,false,372, 60,false)); // add traffic light to a particular city
			createdCities[i].addSignal(new Signal(true,false,false,372, 150,false)); // add traffic light to a particular city
			createdCities[i].addSignal(new Signal(true,false,false,395, 117,true)); // add traffic light to a particular city
			createdCities[i].addSignal(new Signal(true,false,false,372, 445,false)); // add traffic light to a particular city
		}
		else if(index>6 &  index<=8) {
			signal =new Signal(true,false,false,310, 117,true);
			createdCities[i].addSignal(signal); // add traffic light to a particular city
			signal =new Signal(true,false,false,372, 60,false);
			createdCities[i].addSignal(signal); // add traffic light to a particular city
			
			signal =new Signal(true,false,false,372, 150,false);
			createdCities[i].addSignal(signal); // add traffic light to a particular city
			signal =new Signal(true,false,false,395, 117,true);
			createdCities[i].addSignal(signal); // add traffic light to a particular city

			signal =new Signal(true,false,false,170, 445,false);
			createdCities[i].addSignal(signal); // add traffic light to a particular city
			signal =new Signal(true,false,false,372, 445,false);
			createdCities[i].addSignal(signal); // add traffic light to a particular city
			signal =new Signal(true,false,false,672, 445,false);
			createdCities[i].addSignal(signal); // add traffic light to a particular city
		}
	else {
		city.addSignal(new Signal(true,false,false,310, 117,true)); // add traffic light to a particular city
		city.addSignal(new Signal(true,false,false,372, 60,false)); // add traffic light to a particular city

		city.addSignal(new Signal(true,false,false,372, 150,false)); // add traffic light to a particular city
		city.addSignal(new Signal(true,false,false,395, 117,true)); // add traffic light to a particular city

		city.addSignal(new Signal(true,false,false,170, 445,false)); // add traffic light to a particular city
		city.addSignal(new Signal(true,false,false,372, 445,false)); // add traffic light to a particular city
		city.addSignal(new Signal(true,false,false,672, 445,false));} // add traffic light to a particular city
	}

	/**Control the spawn and the position of the vehicles**/
	public void addVehicle(int index,int i) {
		if(index>0 & index<=2) {
			vehicles[total]=new Bus(804, 135);
			vehicles[total].turn3();
			createdCities[i].addVehicle(vehicles[total]);
			total++;
		}
		else if(index>2 & index<=4) {
			int a=(int) (Math.random() * 3); 
			if(a==0) {
				vehicles[total]=new Bus(804, 135);
				vehicles[total].turn3();
				createdCities[i].addVehicle(vehicles[total]);
				total++;}
		
			else if(a==1) {
				vehicles[total]=new Car(354, 0);
				vehicles[total].turn1();
				createdCities[i].addVehicle(vehicles[total]);
				total++;}
		}
		else if(index>4 & index<=6) {
			int a=(int) (Math.random() * 5); 
			if(a==0) {
				vehicles[total]=new Bus(804, 135);
				vehicles[total].turn3();
				createdCities[i].addVehicle(vehicles[total]);
				total++;}
		
			else if(a==1) {
				vehicles[total]=new Car(354, 0);
				vehicles[total].turn1();
				createdCities[i].addVehicle(vehicles[total]);
				total++;}
		
			else if(a==2) {
			vehicles[total]=new Bike(385, 580);
			vehicles[total].turn2();
			createdCities[i].addVehicle(vehicles[total]);
			total++;}
			else if(a==3) {
			
			vehicles[total]=new Car(0, 404);

			createdCities[i].addVehicle(vehicles[total]);
			total++;}
		}
		else if(index>6 &  index<=8) {
			int a=(int) (Math.random() * 5); 
			if(a==0) {
				vehicles[total]=new Bus(804, 135);
				vehicles[total].turn3();
				createdCities[i].addVehicle(vehicles[total]);
				total++;}
		
			else if(a==1) {
				vehicles[total]=new Car(354, 0);
				vehicles[total].turn1();
				createdCities[i].addVehicle(vehicles[total]);
				total++;}
		
			else if(a==2) {
			vehicles[total]=new Bike(385, 580);
			vehicles[total].turn2();
			createdCities[i].addVehicle(vehicles[total]);
			total++;}
			else if(a==3) {
			
			vehicles[total]=new Car(0, 404);

			createdCities[i].addVehicle(vehicles[total]);
			total++;}
			else if(a==4) {
				vehicles[total]=new Bike(185, 580);
				vehicles[total].turn2();
				city.addVehicle(vehicles[total]);
				total++;}
			else if(a==5) {
				
				vehicles[total]=new Bike(685, 580);
				vehicles[total].turn2();
				city.addVehicle(vehicles[total]);
				total++;}
		}
		

		else {
			int a=(int) (Math.random() * 5); 
			if(a==0) {
		
			vehicles[total]=new Bike(185, 580);
			vehicles[total].turn2();
			city.addVehicle(vehicles[total]);
			total++;}
		
			else if(a==1) {
			vehicles[total]=new Car(385, 580);
			vehicles[total].turn2();
			city.addVehicle(vehicles[total]);
			total++;}
		
			else if(a==2) {
			vehicles[total]=new Bike(685, 580);
			vehicles[total].turn2();
			city.addVehicle(vehicles[total]);
			total++;}
			else if(a==3) {
			
			vehicles[total]=new Car(354, 0);
			vehicles[total].turn1();
			city.addVehicle(vehicles[total]);
			total++;}
			
			else if(a==4) {
				
				vehicles[total]=new Bus(810, 135);
				vehicles[total].turn3=true;
				city.addVehicle(vehicles[total]);
				
				total++;}
			
			else {
			
			vehicles[total]=new Bus(0, 404);
			city.addVehicle(vehicles[total]);
			total++;	}	
			
		}
	}

	/**Control the condition of the simulator**/
	public void run() {
		while(simulationRunning ==true & open==false) {
			city.step();
			city.repaint();
			check();
			vehicleNumLabel.setText(String.valueOf(total));
			if(counter ==10 & total!=29) {
				addVehicle(-10,0);
				counter =0;
				
			}

			counter++;

			int sleepNumber = 500; // default number for thread sleep
			if (updateRateNum == 1){ // if the input is 1
				sleepNumber = 500; // set default number for thread sleep
				updateRateNumStat.setText(String.valueOf(updateRateNum)); // change the rate number status label
			}
			else if (updateRateNum == 2){ // if the input is 2
				sleepNumber = 400; // default number for thread sleep
				updateRateNumStat.setText(String.valueOf(updateRateNum)); // change the rate number status label
			}
			else if (updateRateNum == 3){ // if the input is 3
				sleepNumber = 300; // default number for thread sleep
				updateRateNumStat.setText(String.valueOf(updateRateNum)); // change the rate number status label
			}
			else if (updateRateNum == 4){ // if the input is 4
				sleepNumber = 200; // default number for thread sleep
				updateRateNumStat.setText(String.valueOf(updateRateNum)); // change the rate number status label
			}
			else if (updateRateNum == 5){ // if the input is 5
				sleepNumber = 100; // default number for thread sleep
				updateRateNumStat.setText(String.valueOf(updateRateNum)); // change the rate number status label
			}

			try {
				Thread.sleep(sleepNumber);
			}
			catch(Exception exception) {
				exception.printStackTrace();
			}
		}

		while(simulationRunning ==true & open==true) {
			
			createdCities[anotherIndex].step();
			createdCities[anotherIndex].repaint();
			check();
			vehicleNumLabel.setText(String.valueOf(total));
			if(counter ==10 & total!=29) {
				addVehicle(indexNumber, anotherIndex);
				counter =0;
				
			}

			counter++;
			
			
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				e.printStackTrace();
			}}
		}


	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(buttonRun)) {
			
			if(simulationRunning ==false) {
				simulationRunning =true;
				Thread t=new Thread(this);
				t.start();
				
				
			}
			}
		if(event.getSource().equals(buttonStop)) {
			simulationRunning = false;
		}
	}

	/**Method to Play Music**/
	public static void playMusic(){
		try{
			FileInputStream fileInput = new FileInputStream("bgMusic.mp3"); // open music
			Player player = new Player(fileInput); // add Player
			player.play(); // play the song
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (JavaLayerException e){
			e.printStackTrace();
		}
	}
	/**Main that calls other classes**/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Traffic frame = new Traffic(); // run the frame
					frame.setVisible(true); // set the frame to visible
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		playMusic(); // play music
	}
	
}

