package order;

public class Crust implements PizzaParts{
    private double price;
    private String name;
    private final int size;
    private int inventory_num;

    // default constructor, in case crust is normal
    public Crust (int a){
        price = 0;
        name = "Normal";
        size = a;
        inventory_num = 1000;
    }

    public void set_price(){
        if (this.size == 40) {
            this.price += 0.4;
        }
    }

    public void change_Price(double price) {
        this.price = price;
    }


    public void setName(String name) {
        this.name = name;
    }


    public double get_price(){return Math.round(this.price * 100.0) / 100.0;}

    public String get_name(){return name;}

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
