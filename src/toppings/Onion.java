package toppings;

import order.Topping;

public class Onion extends Topping{
    public Onion(int a){
        super(a);
        change_Price(0.3);
        setName("Onion");
    }
}
