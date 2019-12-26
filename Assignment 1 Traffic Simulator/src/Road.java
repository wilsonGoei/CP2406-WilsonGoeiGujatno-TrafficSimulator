public class Road {

    String name;
    int road_length;
    Car vehicle;

    TrafficLights trafficlight;
    Road Road_to_Road;

    Object [] pavement;

    boolean arrive_to_traffic = false;

    public Road (String name, int road_length, Car vehicle, TrafficLights trafficlight, Road Road_to_Road) {

        this.name=name;
        this.road_length =road_length;
        this.vehicle=vehicle;

        this.trafficlight =trafficlight;
        this.Road_to_Road = Road_to_Road;

        this.pavement =new Object[road_length];
        pavement[0]=vehicle;
        pavement[this.road_length -1]=trafficlight;
    }

    public void position_info(Car vehicle) {

        if(vehicle.position<this.road_length) {

            this.pavement[vehicle.position] = this.vehicle;
        }
        else if(vehicle.position==this.road_length){

            if(trafficlight.color.equalsIgnoreCase("Green")) {

                vehicle.position = 0;
                vehicle.current_car_position = Road_to_Road;
                arrive_to_traffic = true;
            }

            else {

                vehicle.position -= 1;
            }
        }
    }
}
