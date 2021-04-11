package toppings;

import order.Topping;

public class Jalapenos extends Topping{
    public Jalapenos(int a){
        super(a);
        change_Price(0.75);
        setName("Jalapenos");
    }
}
