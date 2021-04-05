package delivery;

public class Scooter extends Vehicle{

    public Scooter (String a){
        super(a);
        this.type = "Scooter";
        this.time = 45;
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
