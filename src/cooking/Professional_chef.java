package cooking;

import order.Order;
import order.Pizza;

public class Professional_chef extends Chef{

    public Professional_chef(){
        super();
        this.cook_time_prepare = 4;
        this.name = "Mario";
    }

    public void make_pizza(Order order){
        int time = 0;

        // calculating time it takes to prepare pizzas
        for (Pizza item: order.pizzas){
            time += this.cook_time_prepare;
        }

        // calculating time it takes to cook pizzas
        time += (int)Math.ceil((double) order.pizzas.size() / (double) this.oven_limit);

        order.time += time;
    }
}
