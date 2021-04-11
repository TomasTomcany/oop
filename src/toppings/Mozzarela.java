package toppings;

import order.Topping;

public class Mozzarela extends Topping{
    public Mozzarela(int a){
        super(a);
        change_Price(0.6);
        setName("Mozzarella");
    }
}
