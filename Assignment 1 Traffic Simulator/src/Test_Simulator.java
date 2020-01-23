import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class Test_Simulator {

    public static void main(String[] args) throws InterruptedException,NullPointerException {
        JFrame mainFrame = new JFrame("Traffic Simulator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame frame = new Frame();
        mainFrame.add(frame);
        frame.getModeList().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getItem().toString().equalsIgnoreCase("City Editing")){
                    frame.FrameSimulation();
                }
                else {
                    frame.FrameEdit();
                }
            }
        });
        mainFrame.pack();
        mainFrame.setVisible(true);

        Car vehicle;
        Boolean finish=false;
        vehicle=new Car("Car",0,null);

        TrafficLights light=new TrafficLights("Green",6.0);

        Road road;
        Road Road5=new Road("Road 5 in Position ",5,vehicle, light, null);
        Road Road4=new Road("Road 4 in Position ",8,vehicle, light, Road5);
        Road Road3=new Road("Road 3 in Position ",9,vehicle, light, Road4);
        Road Road2=new Road("Road 2 in Position ",4,vehicle, light, Road3);
        Road Road1=new Road("Road 1 in Position ",2,vehicle, light, Road2);

        vehicle.current_car_position=Road1;
        road=vehicle.current_car_position;

        while(finish == false) {
            light.set_light_status();
            System.out.println(vehicle.name + " at " + vehicle.current_car_position.name
                    + vehicle.position + " Traffic Light Condition: " + light.color);
            vehicle.movement();
            road.position_info(vehicle);
            if (road.arrive_to_traffic == true) {

                if(road.Road_to_Road == null) {
                    finish = true;
                }

                road=vehicle.current_car_position;
            }

            Thread.sleep(1700);
        }
    }
}
