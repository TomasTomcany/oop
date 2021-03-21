package pizza;

public class Crust {
    public double price = 0;
    public String name= "Normal";

    public void set_price(){
        if (Pizza.size == 40) {
            price += 0.4;
        }
    }
    public double get_price(){return price;}
    public String get_name(){return name;}
}
