package toppings;

import order.Topping;

public class Bacon extends Topping{
    public Bacon(int a){
        super(a);
        change_Price(0.8);
        setName("Bacon");
    }
}
