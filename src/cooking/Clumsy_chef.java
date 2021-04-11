package cooking;

import order.Order;

import java.util.Random;

public class Clumsy_chef extends Chef{

    public Clumsy_chef(){
        super();
        setCook_time_prepare(6);
        setName("Luigi");
    }

    public void make_pizza(Order order){
        int time = 0;
        Random rand = new Random();

        // calculating time it takes to prepare pizzas
        for (int i = 0; i < order.getPizzas().size(); i++){
            int random = rand.nextInt(4);
            // there is 25% chance that he messes up current pizza and has to prepare another one
            if (random == 3){i--;}

            time += getCook_time_prepare();
        }

        // calculating time it takes to cook pizzas - number of pizzas divided by oven limit rounded up
        time += (int)Math.ceil((double) order.getPizzas().size() / (double) getOven_limit());

        order.add_time(time);
    }
}
