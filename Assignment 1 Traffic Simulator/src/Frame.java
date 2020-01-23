import javax.swing.*;
import java.awt.*;

public class Frame extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JComboBox modeList;

    public Frame(){
        setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLayout(new BorderLayout());
        JPanel panelTop = new JPanel();
        JLabel simulatorName = new JLabel("Traffic Simulator");
        simulatorName.setFont(new Font("Roboto",Font.BOLD,30));
        panelTop.add(simulatorName);
        add(panelTop,BorderLayout.PAGE_START);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));
        button1 = new JButton("SET UPDATE RATE");
        button1.setFont(new Font("ROBOTO", Font.BOLD,22));
        button1.setPreferredSize(new Dimension(300,100));
        button2 = new JButton("SET VEHICLE SPAWN RATE");
        button2.setFont(new Font("ROBOTO", Font.BOLD,22));
        button2.setPreferredSize(new Dimension(300,100));
        button3 = new JButton("RUN");
        button3.setFont(new Font("ROBOTO", Font.BOLD,22));
        button3.setPreferredSize(new Dimension(300,100));
        button4 = new JButton("STOP");
        button4.setFont(new Font("ROBOTO", Font.BOLD,22));
        button4.setPreferredSize(new Dimension(300,100));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        add(panel,BorderLayout.WEST);

        JPanel panelBottom = new JPanel();
        panelBottom.setLayout(new BorderLayout());
        JPanel innerPanelBottom = new JPanel();
        innerPanelBottom.setLayout(new BorderLayout());
        JPanel gridBagLayout = new JPanel();
        gridBagLayout.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        Font bottomFont = new Font("Roboto",Font.BOLD,22);
        Insets statistic = new Insets(10,100,0,0);
        Insets data = new Insets(10,10,0,0);
        JLabel mode = new JLabel("Mode:");
        mode.setFont(bottomFont);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(10,20,0,0);
        gridBagLayout.add(mode,constraints);
        String [] modeItems = {"City Editing","Simulation"};
        modeList = new JComboBox(modeItems);
        modeList.setSelectedIndex(1);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = data;
        gridBagLayout.add(modeList,constraints);
        JLabel activeCity = new JLabel("Active City:");
        activeCity.setFont(bottomFont);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.insets = statistic;
        gridBagLayout.add(activeCity,constraints);
        JLabel cityName = new JLabel("City Name");
        cityName.setFont(bottomFont);
        constraints.gridx = 3;
        constraints.gridy = 0;
        constraints.insets = data;
        gridBagLayout.add(cityName,constraints);
        JLabel vehicleStat = new JLabel("Number of Vehicles:");
        vehicleStat.setFont(bottomFont);
        constraints.gridx = 4;
        constraints.gridy = 0;
        constraints.insets = statistic;
        gridBagLayout.add(vehicleStat,constraints);
        JLabel vehicleNum = new JLabel("number");
        vehicleNum.setFont(bottomFont);
        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.insets = data;
        gridBagLayout.add(vehicleNum,constraints);
        JLabel trafficStat = new JLabel("Number of Traffic Lights:");
        trafficStat.setFont(bottomFont);
        constraints.gridx = 6;
        constraints.gridy = 0;
        constraints.insets = statistic;
        gridBagLayout.add(trafficStat,constraints);
        JLabel trafficNum = new JLabel("number");
        trafficNum.setFont(bottomFont);
        constraints.gridx = 7;
        constraints.gridy = 0;
        constraints.insets = data;
        gridBagLayout.add(trafficNum,constraints);
        JLabel speedStat  = new JLabel("Vehicle Average Speed:");
        speedStat.setFont(bottomFont);
        constraints.gridx = 8;
        constraints.gridy = 0;
        constraints.insets = statistic;
        gridBagLayout.add(speedStat,constraints);
        JLabel speedNum = new JLabel("Number");
        speedNum.setFont(bottomFont);
        constraints.gridx = 9;
        constraints.gridy = 0;
        constraints.insets = data;
        gridBagLayout.add(speedNum,constraints);
        innerPanelBottom.add(gridBagLayout,BorderLayout.WEST);
        add(innerPanelBottom,BorderLayout.PAGE_END);

    }

    public void FrameEdit(){
        button1.setText("NEW");
        button2.setText("OPEN");
        button3.setText("SAVE");
        button4.setText("EXIT");
    }

    public void FrameSimulation(){
        button1.setText("Set Update Rate");
        button2.setText("Set Vehicle Spawn Rate");
        button3.setText("RUN");
        button4.setText("STOP");
    }

    public JComboBox getModeList() {
        return modeList;
    }
}


