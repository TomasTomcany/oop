package pizza;

public class Crust implements PizzaParts{
    public double price;
    public String name;
    private int size;

    // defaul constructor, case crust is normal
    public Crust (int a){
        price = 0;
        name = "Normal";
        size = a;
    }

    public void set_price(){
        if (this.size == 40) {
            price += 0.4;
        }
    }
    public double get_price(){return price;}
    public String get_name(){return name;}
}
