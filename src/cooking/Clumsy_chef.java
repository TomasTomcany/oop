package cooking;

import databases.Inventory;
import order.Order;

import java.util.Random;

public class Clumsy_chef extends Chef{

    public Clumsy_chef(){
        super();
        setCook_time_prepare(3);
        setName("Luigi");
    }

    @Override
    public void make_pizza(Order order, boolean isQueue) throws Exception {
        int time = 0;

        // checking if the function was called through method make queue
        if (!isQueue) {
            // makes all other pizza chef has in queue and ads to time for this order
            time += this.make_queue();
        }

        boolean failed = false;
        Random rand = new Random();

        // calculating time it takes to prepare pizzas
        for (int i = 0; i < order.getPizzas().size(); i++){
            int random = rand.nextInt(4);
            // there is 25% chance that he messes up current pizza and has to prepare another one
            if (random == 3){
                i--;
                failed = true;
            }

            // adding time for preparation of pizza for each pizza
            time += getCook_time_prepare();

            // expending ingredients from inventory
            if (failed){
                order.getPizzas().get(i+1).expend_ingredients();
            }
            else {
                order.getPizzas().get(i).expend_ingredients();
            }

            failed = false;
        }

        // calculating time it takes to cook pizzas - number of pizzas divided by oven limit rounded up and
        // multiplied by the time it takes to cook the pizza
        time += ((int)Math.ceil((double) order.getPizzas().size() / (double) getOven_limit())) * this.cook_time;

        order.add_time(time);
    }
}
