package delivery;

public class Scooter implements Vehicle{
    private final String type;                    // type of vehicle
    private int time;                       // time it takes to deliver order to customer
    private final String traffic;

    public Scooter (String a){
        this.traffic = a;
        this.type = "Scooter";
        this.time = 45;
    }

    public int getTime() {
        return time;
    }

    public int deliver(){
        if (this.traffic.equals("Jammed")){             // traffic jam causes delivery to be slightly longer
            this.time += 5;
        }
        else if (this.traffic.equals("Free")){          // free road makes delivery time slightly faster
            this.time -= 5;
        }

        return this.time;
    }
}
