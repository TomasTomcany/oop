package delivery;

import order.Order;

public abstract class Vehicle {
    String type;                    // type vehicle
    int time;                       // time it takes to deliver order to customer
    String traffic;

    public Vehicle(String a){
        this.traffic = a;
    }

    public int deliver(){return 0;}
}
