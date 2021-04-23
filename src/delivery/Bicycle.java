package delivery;

public class Bicycle implements Vehicle{
    private final String type;                    // type of vehicle
    private int time;                       // time it takes to deliver order to customer
    private final String traffic;

    public Bicycle(String a){
        this.traffic = a;
        this.type = "Bicycle";
        this.time = 60;
    }

    public int deliver() {
        return this.time;                       // traffic does not matter to bicycle
    }

    public int getTime() {
        return time;
    }
}
