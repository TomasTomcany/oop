package toppings;

import order.Topping;

public class Ham extends Topping{
    public Ham(int a){
        super(a);
        change_Price(0.8);
        setName("Ham");
    }
}
