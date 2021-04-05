package delivery;

public class Bicycle extends Vehicle{

    public Bicycle(String a){
        super(a);
        this.type = "Bicycle";
        this.time = 60;
    }

    public int deliver(){
        return this.time;                       // traffic does not matter to bicycle
    }
}
