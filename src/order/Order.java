package order;

import java.util.ArrayList;
import java.util.Random;

import cooking.Chef;
import cooking.Clumsy_chef;
import cooking.New_chef;
import cooking.Professional_chef;
import delivery.Bicycle;
import delivery.Car;
import delivery.Scooter;
import delivery.Vehicle;

public class Order {
    public final ArrayList<Pizza> pizzas;
    public int time;
    String order_name;
    boolean is_done;
    Chef chef;
    Vehicle vehicle;
    public double price;
    boolean delivery;
    private final String[] traffic = {"Jam", "Free", "Normal"};

    public Order(String a, ArrayList<Pizza> order, boolean b) {
        this.order_name = a;
        this.pizzas = order;
        this.time = 0;
        this.is_done = false;
        this.chef = null;
        this.delivery = b;

        // setting the price of the order based on the prices of pizzas in the order
        for (Pizza item: order){
            price += item.get_price();
        }
    }

    public double get_price(){
        return this.price;
    }


    // creating string for printing price of the order in text area
    public String final_price(){
        return "Final price of the order: " + this.get_price() + "€\n";
    }

    // creating string for printing time it will take to prepare and maybe deliver order
    public String final_time(){
        if (delivery){
            return "Your order will arrive in " + this.time + " minutes.\n";
        }
        else{
            return "Your order will be ready in " + this.time + " minutes.\n";
        }
    }

    // assigning chef to do the order
    public void assign_chef(Chef a){
        this.chef = a;
    }

    // doing the order, calculating the time it takes to cook based on the chef and order
    public void do_order(){

        // handling cooking


        Random rand = new Random();                         // randomly choosing chef for the order
        int random = rand.nextInt(3);
        if (random == 0){
            assign_chef(new Professional_chef());
        }
        else if(random == 1){
            assign_chef(new New_chef());
        }
        else{
            assign_chef(new Clumsy_chef());
        }
        chef.make_pizza(this);                       // adds time of handling the order, polymorphism

        if (this.chef == null){
            System.out.println("No chef assigned to the order!.\n");
        }


        // handling delivery
        if (delivery){
            random = rand.nextInt(3);
            int traffic_choice = rand.nextInt(3);

            if (random == 0){
                vehicle = new Car(traffic[traffic_choice]);
            }
            else if (random == 1){
                vehicle = new Scooter(traffic[traffic_choice]);
            }
            else{
                vehicle = new Bicycle(traffic[traffic_choice]);
            }

            this.time += vehicle.deliver();     // adds time it takes to deliver
            this.price += 0.5;                              // adds to price for delivering
        }


        is_done = true;
    }
}
