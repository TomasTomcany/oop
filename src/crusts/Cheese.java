package crusts;

import order.Crust;

public class Cheese extends Crust{
    public Cheese(int a){
        super(a);
        change_Price(1);
        setName("Cheese");
    }
}
