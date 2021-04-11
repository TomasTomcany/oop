package order;

public abstract class Topping implements PizzaParts{
    private double price;
    private String name;
    private final int size;

    public Topping(int a){
        size = a;
    }

    public void set_price(){
        if (this.size == 40) {
            this.price *= 1.35;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void chnage_Price(double price) {
        this.price = price;
    }

    public double get_price(){return Math.round(this.price * 100.0) / 100.0;}
    public String get_name(){return name;}
}
