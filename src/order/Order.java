package order;

import java.util.ArrayList;
import java.util.Random;

import cooking.Chef;
import cooking.Clumsy_chef;
import cooking.New_chef;
import cooking.Professional_chef;
import databases.Order_db;
import delivery.strategies.FreeTrafficStartegy;
import delivery.strategies.JammedTrafficStrategy;
import delivery.strategies.NormalTrafficStrategy;
import delivery.vehicles.Bicycle;
import delivery.vehicles.Car;
import delivery.vehicles.Scooter;
import delivery.vehicles.Vehicle;

public class Order{

    private final ArrayList<Pizza> pizzas;
    private int time;
    private final String order_name;
    private boolean is_done;
    private Chef chef;
    private String chef_name;
    private Vehicle vehicle = new Car();
    private double price;
    private final boolean delivery;
    private final Order_db order_db = Order_db.getInstance();
    private final String traffic;

    // constructor
    public Order(String a, ArrayList<Pizza> order, boolean b, String tr_situation) {
        this.order_name = a;
        this.pizzas = order;
        this.time = 0;
        this.is_done = false;
        this.chef = null;
        this.delivery = b;
        this.traffic = tr_situation;

        // setting the price of the order based on the prices of pizzas in the order
        for (Pizza item: order){
            price += item.get_price();
        }

        // randomly choosing chef for the order
        Random rand = new Random();
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
        this.chef_name = this.chef.getName();

        if (delivery) {
            // randomly choosing vehicle and traffic for the order
            random = rand.nextInt(3);
            if (random == 0) {
                this.vehicle = new Car();
            } else if (random == 1) {
                this.vehicle = new Scooter();
            } else {
                this.vehicle = new Bicycle();
            }
        }
    }

    // getters and setters
    public String getChef_name() {
        return chef_name;
    }

    public String getPrice() {
        return String.format("%.2f", price);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isIs_done() {
        return is_done;
    }

    public double get_price(){
        return Math.round(this.price * 100.0) / 100.0;
    }

    public void add_time(int t) {this.time += t;}

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public String getOrder_name() {
        return order_name;
    }

    public int getTime() {
        return time;
    }

    public boolean isDelivery() {
        return delivery;
    }




    // assigning chef to do the order
    public void assign_chef(Chef a){
        this.chef = a;
    }

    // doing the order, calculating the time it takes to cook based on the chef and order
    public void do_order(boolean is_db, boolean isQueue) throws Exception {

        // handling cooking
        chef.make_pizza(this, isQueue);                        // adds time of handling the order, polymorphism

        // handling delivery
        if (delivery) {
            // setting up strategy
            if (traffic.equals("Normal")) {
                vehicle.setTrafficStrategy(new NormalTrafficStrategy());
            }
            else if (traffic.equals("Jammed")) {
                vehicle.setTrafficStrategy(new JammedTrafficStrategy());
            }
            else {
                vehicle.setTrafficStrategy(new FreeTrafficStartegy());
            }


            this.time += vehicle.deliver();                 // adds time it takes to deliver
            this.price += 0.5;                              // adds to price for delivering
        }


        is_done = true;

        // if not used to complete orders from order database
        if (!is_db) {
            // adding order to order database
            order_db.addOrder(this);
        }
    }
}
