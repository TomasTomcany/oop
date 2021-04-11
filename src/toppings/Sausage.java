package toppings;

import order.Topping;

public class Sausage extends Topping{
    public Sausage(int a){
        super(a);
        change_Price(1);
        setName("Sausage");
    }
}
