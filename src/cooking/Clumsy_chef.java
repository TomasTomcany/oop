package cooking;

import order.Order;

import java.util.Random;

public class Clumsy_chef extends Chef{

    public Clumsy_chef(){
        super();
        this.cook_time_prepare = 6;
        this.name = "Luigi";
    }

    public void make_pizza(Order order){
        int time = 0;
        Random rand = new Random();

        // calculating time it takes to prepare pizzas
        for (int i = 0; i < order.pizzas.size(); i++){
            int random = rand.nextInt(4);
            // there is 25% chance that he messes up current pizza and has to prepare another one
            if (random == 3){i--;}

            time += this.cook_time_prepare;
        }

        // calculating time it takes to cook pizzas
        time += (int)Math.ceil((double) order.pizzas.size() / (double) this.oven_limit);

        order.time += time;
    }
}
