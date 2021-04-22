package inventory;


import bases.*;
import crusts.*;
import order.Base;
import order.Crust;
import order.Topping;
import toppings.*;

import java.util.ArrayList;
import java.util.Locale;

public class Inventory {

    // singleton pattern
    private static Inventory instance;

    private Inventory() {
        // initializing inventory
        bases.add(new Tomato(32));
        bases.add(new Cream(32));
        bases.add(new Habanero(32));

        crusts.add(new Crust(32));
        crusts.add(new Cheese(32));
        crusts.add(new Garlic(32));

        toppings.add(new Bacon(32));
        toppings.add(new Corn(32));
        toppings.add(new Ham(32));
        toppings.add(new Jalapenos(32));
        toppings.add(new Mozzarela(32));
        toppings.add(new Mushroom(32));
        toppings.add(new Sausage(32));
        toppings.add(new Olives(32));
        toppings.add(new Onion(32));
        toppings.add(new Pepperoni(32));
    }

    public static Inventory getInstance()   {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }


    private ArrayList<Base> bases = new ArrayList<>();
    private ArrayList<Crust> crusts = new ArrayList<>();
    private ArrayList<Topping> toppings = new ArrayList<>();


    public ArrayList<Base> getBases() {
        return bases;
    }

    public ArrayList<Crust> getCrusts() {
        return crusts;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void expend_base(Base base) throws Exception {
        // expending specific base in database
        for (Base item: bases){
            if (item.get_name().equals(base.get_name())){
                // if there is not enough of the item on the inventory, pizza cant be made of it
                if (item.getInventory_num() < 1){
                    throw new Exception(item.get_name() + " is not on the inventory!\n");
                }
                item.lower_Inventory_num();
            }
        }
    }

    public void expend_crust(Crust crust) throws Exception {
        // expending specific base in database
        for (Crust item: crusts){
            if (item.get_name().equals(crust.get_name())){
                // if there is not enough of the item on the inventory, pizza cant be made of it
                if (item.getInventory_num() < 1){
                    throw new Exception(item.get_name() + " is not on the inventory!\n");
                }
                item.lower_Inventory_num();
            }
        }
    }

    public void expend_toppings(Topping topping) throws Exception {
        // expending specific base in database
        for (Topping item: toppings){
            if (item.get_name().equals(topping.get_name())){
                // if there is not enough of the item on the inventory, pizza cant be made of it
                if (item.getInventory_num() < 1){
                    throw new Exception(item.get_name() + " is not on the inventory!\n");
                }
                item.lower_Inventory_num();
            }
        }
    }

    public String get_Inventory_info(){
        // gets string of name, price and amount in inventory of all ingredients in inventory
        StringBuilder info = new StringBuilder();

        for (Base item: bases){
            info.append(item.get_name()).append("   ").append(item.get_price()).append(" "  )
                        .append(item.getInventory_num()).append("\n");
        }
        info.append("\n");

        for (Crust item: crusts){
            info.append(item.get_name()).append("   ").append(item.get_price()).append("   ")
                    .append(item.getInventory_num()).append("\n");
        }
        info.append("\n");

        for (Topping item: toppings){
            info.append(item.get_name()).append("   ").append(item.get_price()).append("   ")
                    .append(item.getInventory_num()).append("\n");
        }
        info.append("\n");

        return info.toString();
    }

    public String check_low_Inventory(){
        StringBuilder info = new StringBuilder();

        for (Base item: bases){
            // checking if there is a low amount of specific base on inventory
            if (item.getInventory_num() < 10){
                // if there is print warning about low amount on inventory
                info.append("Low amount of ").append(item.get_name()).append(" on the inventory (")
                            .append(item.getInventory_num()).append(").\n");
            }
        }

        for (Crust item: crusts){
            // checking if there is a low amount of specific base on inventory
            if (item.getInventory_num() < 10){
                // if there is print warning about low amount on inventory
                info.append("Low amount of ").append(item.get_name()).append(" on the inventory (")
                        .append(item.getInventory_num()).append(").\n");
            }
        }

        for (Topping item: toppings){
            // checking if there is a low amount of specific base on inventory
            if (item.getInventory_num() < 10){
                // if there is print warning about low amount on inventory
                info.append("Low amount of ").append(item.get_name()).append(" on the inventory (")
                        .append(item.getInventory_num()).append(").\n");
            }
        }

        return info.toString();
    }

    public void add_amount(String name, int amount){
        for (Base item: bases){
            // if it finds the item in the arraylist, adds the amount and returns
            if (item.get_name().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))){
                item.add_Inventory_num(amount);
                return;
            }
        }

        for (Crust item: crusts){
            // if it finds the item in the arraylist, adds the amount and returns
            if (item.get_name().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))){
                item.add_Inventory_num(amount);
                return;
            }
        }

        for (Topping item: toppings){
            // if it finds the item in the arraylist, adds the amount and returns
            if (item.get_name().toLowerCase(Locale.ROOT).equals(name.toLowerCase(Locale.ROOT))){
                item.add_Inventory_num(amount);
                return;
            }
        }
    }
}
