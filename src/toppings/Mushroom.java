package toppings;

import order.Topping;

public class Mushroom extends Topping{
    public Mushroom(int a){
        super(a);
        change_Price(0.4);
        setName("Mushroom");
    }
}
