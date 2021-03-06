package order;

import java.io.Serializable;

public abstract class Topping implements PizzaParts, Serializable {
    private double price;
    private String name;
    private final int size;
    private int inventory_num;

    public Topping(int a){
        size = a;
        inventory_num = 100;
    }

    public void set_price(){
        if (this.size == 40) {
            this.price *= 1.35;
        }
    }

    public double get_price(){return Math.round(this.price * 100.0) / 100.0;}

    public String get_name(){return name;}

    public void setName(String name) {
        this.name = name;
    }

    public void change_Price(double price) {
        this.price = price;
    }

    public void lower_Inventory_num() {
        this.inventory_num -= 1;
    }

    public void add_Inventory_num(int n){
        this.inventory_num += n;
    }

    public int getInventory_num() {
        return inventory_num;
    }
}
