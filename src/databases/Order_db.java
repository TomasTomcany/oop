package databases;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import order.*;

import java.util.ArrayList;
import java.util.Random;

public class Order_db{

    // Singleton pattern
    public static Order_db instance;
    private Order_db(){}

    public static Order_db getInstance()   {
        if (instance == null) {
            instance = new Order_db();
        }
        return instance;
    }


    private final ObservableList<Order> orders = FXCollections.observableArrayList();


    public ObservableList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }


    public void generate_orders(){
        // randomly generate orders that are not done yet
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            ArrayList<Pizza> pizzas = new ArrayList<>();

            // generating pizza object
            int random = rand.nextInt(4);
            for (int k = 0; k < random+1; k++) {
                pizzas.add((new PizzaFactory()).create_pizza());
            }

            // after creating pizzas create order object
            random = rand.nextInt(2);
            boolean bool;
            if (random == 0){
                bool = true;
            }
            else{
                bool = false;
            }

            Order order = new Order("Generated", pizzas, bool, "Normal");

            // adding order to database
            this.addOrder(order);
        }
    }

}
