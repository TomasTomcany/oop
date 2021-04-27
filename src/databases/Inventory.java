package databases;


import bases.*;
import crusts.*;
import exceptions.NotInInventoryException;
import order.Base;
import order.Crust;
import order.Topping;
import toppings.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Inventory implements Serializable {

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



    private final ArrayList<Base> bases = new ArrayList<>();
    private final ArrayList<Crust> crusts = new ArrayList<>();
    private final ArrayList<Topping> toppings = new ArrayList<>();


    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public String get_Inventory_info(){
        // gets string of name, price and amount in inventory of all ingredients in inventory
        StringBuilder info = new StringBuilder();

        for (Base item: bases){
            info.append(item.get_name()).append("   ").append(item.getInventory_num()).append("\n");
        }
        info.append("\n");

        for (Crust item: crusts){
            info.append(item.get_name()).append("   ").append(item.getInventory_num()).append("\n");
        }
        info.append("\n");

        for (Topping item: toppings){
            info.append(item.get_name()).append("   ").append(item.getInventory_num()).append("\n");
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


    // own exception for checking if there is enough on the inventory before making pizza
    static void check_if_enough(int num, String s)throws NotInInventoryException{
        if (num < 1){
            throw new NotInInventoryException(s + " is not on the inventory!\n");
        }
    }

    public void expend_base(Base base) {
        // expending specific base in database
        for (Base item: bases){
            if (item.get_name().equals(base.get_name())){
                // if there is not enough of the item on the inventory, pizza cant be made of it
                try {
                    check_if_enough(item.getInventory_num(), item.get_name());
                }catch(Exception m){
                    System.out.println("NotInInventoryException occurred: ");}

                item.lower_Inventory_num();
            }
        }
    }

    public void expend_crust(Crust crust) {
        // expending specific base in database
        for (Crust item: crusts){
            if (item.get_name().equals(crust.get_name())){
                // if there is not enough of the item on the inventory, pizza cant be made of it
                try{
                check_if_enough(item.getInventory_num(), item.get_name());
                }catch(Exception m){
                    System.out.println("NotInInventoryException occurred: ");}

                item.lower_Inventory_num();
            }
        }
    }

    public void expend_toppings(Topping topping) {
        // expending specific base in database
        for (Topping item: toppings){
            if (item.get_name().equals(topping.get_name())){
                // if there is not enough of the item on the inventory, pizza cant be made of it
                try{
                check_if_enough(item.getInventory_num(), item.get_name());
                }catch(Exception m){
                    System.out.println("NotInInventoryException occurred: ");}

                item.lower_Inventory_num();
            }
        }
    }


    // methods for serializing Inventory database
    public static void saveInventory(){
        // method for saving inventory database into text file
        try{
            FileOutputStream file_out = new FileOutputStream("inv.ser");
            ObjectOutputStream obj_out  = new ObjectOutputStream(file_out);
            obj_out.writeObject(instance);

            obj_out.close();
            file_out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadInventory() throws IOException, ClassNotFoundException {
        // method for loading inventory database from text file
        FileInputStream file_in = new FileInputStream("inv.ser");
        ObjectInputStream obj_in = new ObjectInputStream(file_in);
        instance = (Inventory)obj_in.readObject();

        obj_in.close();
        file_in.close();
    }
}
