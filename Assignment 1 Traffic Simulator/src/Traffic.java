import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

