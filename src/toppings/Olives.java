package toppings;

import order.Topping;

public class Olives extends Topping{
    public Olives(int a){
        super(a);
        change_Price(0.1);
        setName("Olives");
    }
}
