package pizza;

public class Topping {
    public double price = 0;
    public String name= "";

    public void set_price(){
        if (Pizza.size == 40) {
            price *= 1.35;
        }
    }
    public double get_price(){return price;}
    public String get_name(){return name;}
}
