package cooking;

import order.Order;
import order.Pizza;

public class Professional_chef extends Chef{

    public Professional_chef(){
        super();
        setCook_time_prepare(2);
        setName("Mario");
    }

    @Override
    public void make_pizza(Order order, boolean isQueue) throws Exception {
        int time = 0;

        // checking if the function was called through method make queue
        if (!isQueue) {
            // makes all other pizza chef has in queue and ads to time for this order
            time += this.make_queue();
        }

        // calculating time it takes to prepare pizzas
        for (Pizza item: order.getPizzas()){
            time += getCook_time_prepare();
            // expending ingredients from inventory
            item.expend_ingredients();
        }

        // calculating time it takes to cook pizzas - number of pizzas divided by oven limit rounded up and
        // multiplied by the time it takes to cook the pizza
        time += ((int)Math.ceil((double) order.getPizzas().size() / (double) getOven_limit())) * this.cook_time;

        order.add_time(time);
    }
}
