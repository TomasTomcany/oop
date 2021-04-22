package cooking;

import databases.Inventory;
import order.Order;

public abstract class Chef {

    private int cook_time_prepare;                          // time it takes to prepare 1 pizza in minutes
    private final int cook_time;                           // time it takes to cook 1 pizza in minutes
    private final int oven_limit;                          // how may pizzas can be cooked at the same time
    private String name;
    private Inventory inventory;

    Chef (){
        this.cook_time = 15;
        this.oven_limit = 5;
        this.inventory = Inventory.getInstance();
    }

    public int getOven_limit() {
        return oven_limit;
    }

    public int getCook_time_prepare() {
        return cook_time_prepare;
    }

    public void setCook_time_prepare(int cook_time_prepare) {
        this.cook_time_prepare = cook_time_prepare;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void make_pizza(Order order) throws Exception {}

}
