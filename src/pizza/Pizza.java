package pizza;

import java.util.ArrayList;

public class Pizza {
    public int size;
    private double price;
    public Base base;
    public Crust crust;
    public ArrayList<Topping> toppings;

    // constuctor
    public Pizza(int a, Base b, Crust c, ArrayList<Topping> t){
        size = a;
        price = 0;
        this.base = b;
        this.crust = c;
        this.toppings = t;
        // setting price based of its composition
        this.price += base.get_price()+crust.get_price();
        for (Topping item: toppings){
            this.price += item.get_price();
        }
    }


    public double get_price(){return Math.round(this.price * 100.0) / 100.0;}

    public int get_size(){return size;}

    public String info(){
        StringBuilder info;
        info = new StringBuilder("Size: " + get_size() + "€\n" +
                "Base: " + base.get_name() + " " + base.get_price() + "€\n" +
                "Crust: " + crust.get_name() + " " + crust.get_price() + "€\n");
        for (Topping item: toppings){
            info.append("Topping: ").append(item.get_name()).append(" ").append(item.get_price()).append("€\n");
        }
        info.append("Price of pizza: ").append(get_price()).append("€\n");
        return info.toString();
    }
}
