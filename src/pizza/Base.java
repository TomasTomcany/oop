package pizza;
import bases.*;

public class Base {
    public static double price = 0;
    public static String name = "";

    public void set_price(){
        if (Pizza.size == 40){
            price *= 1.5;
        }
    }

    public double get_price(){return this.price;}

    public String get_name() {return this.name;}
}
