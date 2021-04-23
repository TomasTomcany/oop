package delivery;

public class Car implements Vehicle{
    private final String type;                    // type of vehicle
    private int time;                       // time it takes to deliver order to customer
    private final String traffic;

    public Car(String a){
        this.traffic = a;
        this.type = "Car";
        this.time = 30;
    }

    public int getTime() {
        return time;
    }

    public int deliver(){
        if (this.traffic.equals("Jammed")){         // in case traffic is jammed, double the delivery time
            this.time *= 2;
        }
        else if (this.traffic.equals("Free")){      // in case roads are completely free, halve delivery time
            this.time /= 2;
        }

        return this.time;
    }
}
