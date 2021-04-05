package cooking;

import order.Order;

public abstract class Chef {
    int cook_time_prepare;                   // time it takes to prepare 1 pizza in minutes
    int cook_time;                           // time it takes to cook 1 pizza in minutes
    int oven_limit;                          // how may pizzas can be cooked at the same time
    String name;

    Chef (){
        this.cook_time = 15;
        this.oven_limit = 5;
    }

    public void make_pizza(Order order){}

}
