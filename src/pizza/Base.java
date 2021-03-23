package pizza;
import bases.*;

public class Base implements PizzaParts{
    public double price;
    public String name;
    private int size;

    public Base(int a){
        size = a;
    }
    public void set_price(){
        if (this.size == 40){
            price *= 1.5;
        }
    }

    public double get_price(){return this.price;}

    public String get_name() {return this.name;}
}
