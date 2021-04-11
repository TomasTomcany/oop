package toppings;

import order.Topping;

public class Pepperoni extends Topping{
    public Pepperoni(int a){
        super(a);
        change_Price(0.8);
        setName("Pepperoni");
    }
}
