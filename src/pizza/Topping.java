package pizza;

public class Topping implements PizzaParts{
    public double price;
    public String name;
    private int size;

    public Topping(int a){
        size = a;
    }

    public void set_price(){
        if (this.size == 40) {
            price *= 1.35;
        }
    }
    public double get_price(){return price;}
    public String get_name(){return name;}
}
