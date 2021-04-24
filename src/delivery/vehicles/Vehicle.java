package delivery.vehicles;


import delivery.strategies.Traffic_strategy;

public interface Vehicle {

    int deliver();

    int getTime();

    void setTrafficStrategy(Traffic_strategy ts);
}
