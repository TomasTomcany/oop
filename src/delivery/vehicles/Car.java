package delivery.vehicles;

import delivery.strategies.Traffic_strategy;

public class Car implements Vehicle {
    private final String type;              // type of vehicle
    private int time;                       // time it takes to deliver order to customer
    private Traffic_strategy ts;            // traffic influences time it takes to deliver

    public Car(){
        this.type = "Car";
        this.time = 15;
    }

    public int getTime() {
        return time;
    }

    @Override
    public void setTrafficStrategy(Traffic_strategy ts) {
        this.ts = ts;
    }

    public int deliver(){
        this.time = ts.start_moving(this.time);
        return this.time;
    }
}
