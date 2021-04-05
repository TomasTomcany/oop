package order;

public class Crust implements PizzaParts{
    public double price;
    public String name;
    private int size;

    // default constructor, in case crust is normal
    public Crust (int a){
        price = 0;
        name = "Normal";
        size = a;
    }

    public void set_price(){
        if (this.size == 40) {
            this.price += 0.4;
        }
    }
    public double get_price(){return Math.round(this.price * 100.0) / 100.0;}
    public String get_name(){return name;}
}