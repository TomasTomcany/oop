package order;

import databases.Inventory;

import java.util.ArrayList;

public class Pizza {
    private final int size;
    private double price;
    private final Base base;
    private final Crust crust;
    private final ArrayList<Topping> toppings;

    public Base getBase() {
        return base;
    }

    public Crust getCrust() {
        return crust;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }


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

    public void expend_ingredients() throws Exception {
        // expending all of the ingredients of pizza from inventory
        Inventory inventory = Inventory.getInstance();

        inventory.expend_base(this.base);
        inventory.expend_crust(this.crust);
        for (Topping item: this.toppings){
            inventory.expend_toppings(item);
        }
    }
}
