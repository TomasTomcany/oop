package delivery.vehicles;

import delivery.strategies.Traffic_strategy;

import java.util.Random;

public class Scooter implements Vehicle {
    private final String type;              // type of vehicle
    private int time;                       // time it takes to deliver order to customer
    private Traffic_strategy ts;            // traffic influences time it takes to deliver

    public Scooter (){
        this.type = "Scooter";
        this.time = 25;
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

        Random rand = new Random();
        int random = rand.nextInt(10);
        if (random < 4){                    // 40% chance for scooter to find more efficient route
            this.time -= 5;
        }

        return this.time;
    }
}
