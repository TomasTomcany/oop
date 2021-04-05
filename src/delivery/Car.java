package delivery;

public class Car extends Vehicle{

    public Car(String a){
        super(a);
        this.type = "Car";
        this.time = 30;
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
