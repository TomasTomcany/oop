package cooking;

import order.Order;
import order.Pizza;

public class New_chef extends Chef{

    public New_chef(){
        super();
        setCook_time_prepare(4);
        setName("Waluigi");
    }

    @Override
    public void make_pizza(Order order) throws Exception {
        int time = 0;

        // adding buffer time, since this chef does not know his way around kitchen yet
        time += 5;

        // calculating time it takes to prepare pizzas
        for (Pizza item: order.getPizzas()){
            time += getCook_time_prepare();
            // expending ingredients from inventory
            item.expend_ingredients();
        }

        // calculating time it takes to cook pizzas
        time += (int)Math.ceil((double) order.getPizzas().size() / (double) getOven_limit());

        order.add_time(time);
    }
}
