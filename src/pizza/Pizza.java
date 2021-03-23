package pizza;

import java.util.ArrayList;

public class Pizza {
    public int size;
    private double price;
    public Base base;
    public Crust crust;
    public ArrayList<Topping> toppings;

    // constuctor
    public Pizza(int a){
        size = a;
        price = 0;
        base = new Base(a);
        crust = new Crust(a);
        toppings = new ArrayList<>(a);
    }

    public void add_price(double price){
        this.price += price;
    }

    public double get_price(){return this.price;}

    public int get_size(){return size;}

    public void print_pizza(){
        System.out.println("Size: " + get_size());
        System.out.println("Base: " + base.get_name() +" " + base.get_price());
        System.out.println("Crust: " + crust.get_name() +" " + crust.get_price());
        for (Topping item: toppings){
            System.out.println("Topping: " + item.get_name() +" " + item.get_price());
        }
        System.out.println("Price of pizza: " + get_price());
    }
}
