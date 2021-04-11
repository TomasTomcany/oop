package toppings;

import order.Topping;

public class Corn extends Topping{
    public Corn(int a){
        super(a);
        change_Price(0.4);
        setName("Corn");
    }
}
