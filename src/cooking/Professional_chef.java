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
    public void make_pizza(Order order) throws Exception {
        int time = 0;

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
