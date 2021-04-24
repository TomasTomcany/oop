package delivery.vehicles;

import delivery.strategies.Traffic_strategy;

import java.util.Random;

public class Bicycle implements Vehicle {
    private final String type;                    // type of vehicle
    private int time;                             // time it takes to deliver order to customer
    private Traffic_strategy ts;                  // traffic influences time it takes to deliver

    public Bicycle(){
        this.type = "Bicycle";
        this.time = 45;
    }

    @Override
    public void setTrafficStrategy(Traffic_strategy ts) {
        this.ts = ts;
    }

    public int deliver() {
        this.time = ts.start_moving(this.time);

        Random rand = new Random();
        int random = rand.nextInt(4);
        if (random == 0){                       // 25% chance for delivery guy getting tired
            this.time += 5;
        }

        return this.time;
    }

    public int getTime() {
        return time;
    }
}
