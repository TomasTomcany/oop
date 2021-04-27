package cooking;

import com.sun.org.apache.xpath.internal.operations.Or;
import databases.Inventory;
import databases.Order_db;
import order.Order;

public abstract class Chef {

    private int cook_time_prepare;                          // time it takes to prepare 1 pizza in minutes
    private final int cook_time;                           // time it takes to cook 1 pizza in minutes
    private final int oven_limit;                          // how may pizzas can be cooked at the same time
    private String name;
    private final Inventory inventory;
    private final Order_db order_db;

    Chef (){
        this.cook_time = 10;
        this.oven_limit = 5;
        this.inventory = Inventory.getInstance();
        this.order_db = Order_db.getInstance();
    }

    public int getCook_time() {
        return cook_time;
    }

    public String getName() {
        return name;
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

    public void make_pizza(Order order, boolean isQueue) throws Exception {}

    public int make_queue() throws Exception {
        int time = 0;
        // chef has to make all the other orders in the queue in order to get to this order
        for (Order item: order_db.getOrders()){
            if (item.getChef_name().equals(this.name) && !item.isIs_done()){
                item.do_order(true, true);

                // calculating time it took to make the order for chef
                int temp = item.getTime();

                // if order was deliver subtract the time it has taken to deliver
                if (item.isDelivery()){
                    temp -= item.getVehicle().getTime();
                }

                time += temp;
            }


        }

        return time;
    }
}