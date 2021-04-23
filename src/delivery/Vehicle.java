package delivery;


public interface Vehicle {
    String type = null;                    // type vehicle
    int time = 0;                           // time it takes to deliver order to customer
    String traffic = null;

    int deliver();

    int getTime();
}
