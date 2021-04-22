package order;

public interface PizzaParts {

    void set_price();
    double get_price();
    String get_name();
    void setName(String name);
    void change_Price(double price);
    void lower_Inventory_num();
    void add_Inventory_num(int n);
    int getInventory_num();
}
