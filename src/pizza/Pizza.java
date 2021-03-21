package pizza;

import java.util.ArrayList;

public class Pizza {
    public static int size = 32;
    double price = 0;
    public Base base = new Base ();
    public Crust crust = new Crust();
    public ArrayList<Topping> toppings = new ArrayList<Topping>();

    public void set_size(int size){
        Pizza.size = size;
    }

    public void add_price(double price){
        this.price += price;
    }
    public double get_price(){return this.price;}
    public int get_size(){return size;}
}
