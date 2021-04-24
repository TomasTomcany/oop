package databases;

import bases.Cream;
import bases.Habanero;
import bases.Tomato;
import crusts.Cheese;
import crusts.Garlic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import order.*;
import toppings.*;

import java.io.*;
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
                Base base;
                Crust crust;
                ArrayList<Topping> toppings = new ArrayList<Topping>();

                // choosing base
                int rnd = rand.nextInt(3);
                if (rnd == 0) {
                    base = new Tomato(32);
                } else if (rnd == 1) {
                    base = new Cream(32);
                } else {
                    base = new Habanero(32);
                }

                // choosing crust
                rnd = rand.nextInt(3);
                if (rnd == 0) {
                    crust = new Crust(32);
                } else if (rnd == 1) {
                    crust = new Cheese(32);
                } else {
                    crust = new Garlic(32);
                }

                // choosing toppings
                int rand_for = rand.nextInt(5);
                for (int j = 0; j < rand_for; j++) {
                    rnd = rand.nextInt(10);
                    switch (rnd) {
                        case 0:
                            toppings.add(new Bacon(32));
                            break;
                        case 1:
                            toppings.add(new Corn(32));
                            break;
                        case 2:
                            toppings.add(new Ham(32));
                            break;
                        case 3:
                            toppings.add(new Jalapenos(32));
                            break;
                        case 4:
                            toppings.add(new Mozzarela(32));
                            break;
                        case 5:
                            toppings.add(new Mushroom(32));
                            break;
                        case 6:
                            toppings.add(new Olives(32));
                            break;
                        case 7:
                            toppings.add(new Onion(32));
                            break;
                        case 8:
                            toppings.add(new Pepperoni(32));
                            break;
                        default:
                            toppings.add(new Sausage(32));
                            break;
                    }
                }
                // creating pizza object and adding it to array list of pizzas
                Pizza pizza = new Pizza(32, base, crust, toppings);
                pizzas.add(pizza);
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
