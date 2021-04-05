package cooking;

import order.Order;
import order.Pizza;

public class New_chef extends Chef{

    public New_chef(){
        super();
        this.cook_time_prepare = 8;
        this.name = "Waluigi";
    }

    public void make_pizza(Order order){
        int time = 0;

        // adding buffer time, since this chef does not know his way around kitchen yet
        time += 5;

        // calculating time it takes to prepare pizzas
        for (Pizza item: order.pizzas){
            time += this.cook_time_prepare;
        }

        // calculating time it takes to cook pizzas
        time += (int)Math.ceil((double) order.pizzas.size() / (double) this.oven_limit);

        order.time += time;
    }
}
