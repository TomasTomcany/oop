package order;

import bases.Cream;
import bases.Habanero;
import bases.Tomato;
import controller.Order_controller;
import crusts.Cheese;
import crusts.Garlic;
import toppings.*;

import java.util.ArrayList;
import java.util.Random;

public class PizzaFactory {

    // factory for Order_db.generate orders
    public Pizza create_pizza(){
        Random rand = new Random();
        Base base;
        Crust crust;
        ArrayList<Topping> toppings = new ArrayList<Topping>();

        // choosing base
        int rnd = rand.nextInt(3);
        if (rnd == 0) {
            base = new Tomato(32);
        } else if (rnd == 1) {
            base = new Cream(32);
        } else {
            base = new Habanero(32);
        }

        // choosing crust
        rnd = rand.nextInt(3);
        if (rnd == 0) {
            crust = new Crust(32);
        } else if (rnd == 1) {
            crust = new Cheese(32);
        } else {
            crust = new Garlic(32);
        }

        // choosing toppings
        int rand_for = rand.nextInt(5);
        for (int j = 0; j < rand_for; j++) {
            rnd = rand.nextInt(10);
            switch (rnd) {
                case 0:
                    toppings.add(new Bacon(32));
                    break;
                case 1:
                    toppings.add(new Corn(32));
                    break;
                case 2:
                    toppings.add(new Ham(32));
                    break;
                case 3:
                    toppings.add(new Jalapenos(32));
                    break;
                case 4:
                    toppings.add(new Mozzarela(32));
                    break;
                case 5:
                    toppings.add(new Mushroom(32));
                    break;
                case 6:
                    toppings.add(new Olives(32));
                    break;
                case 7:
                    toppings.add(new Onion(32));
                    break;
                case 8:
                    toppings.add(new Pepperoni(32));
                    break;
                default:
                    toppings.add(new Sausage(32));
                    break;
            }
        }
        // creating pizza object and adding it to array list of pizzas
        return (new Pizza(32, base, crust, toppings));
    }

    // for Order_controller.order_action
    public Pizza create_pizza(Order_controller oc){

        // handling size
        int size;
        if (oc.getSize_32().isSelected()){size = 32;}
        else if (oc.getSize_40().isSelected()){size = 40;}
        else {oc.getText_summary().appendText("Please select size!\n"); return null;}

        // handling base
        Base base;
        if (oc.getBase_tomato().isSelected()){base = new Tomato(size);}
        else if (oc.getBase_cream().isSelected()){base = new Cream(size);}
        else if (oc.getBase_habanero().isSelected()) {base = new Habanero(size);}
        else {oc.getText_summary().appendText("Please select base!\n"); return null;}

        // handling crust
        Crust crust;
        if (oc.getCrust_normal().isSelected()){crust = new Crust(size);}
        else if (oc.getCrust_cheese().isSelected()){crust = new Cheese(size);}
        else if (oc.getCrust_garlic().isSelected()){crust = new Garlic(size);}
        else {oc.getText_summary().appendText("Please select crust!\n"); return null;}

        // handling toppings
        ArrayList<Topping> toppings = new ArrayList<>(size);
        if (oc.getTopping_bacon().isSelected()){toppings.add(new Bacon(size));}
        if (oc.getTopping_corn().isSelected()){toppings.add(new Corn(size));}
        if (oc.getTopping_jalapenos().isSelected()){toppings.add(new Jalapenos(size));}
        if (oc.getTopping_mozzarela().isSelected()){toppings.add(new Mozzarela(size));}
        if (oc.getTopping_mushroom().isSelected()){toppings.add(new Mushroom(size));}
        if (oc.getTopping_olives().isSelected()){toppings.add(new Olives(size));}
        if (oc.getTopping_onions().isSelected()){toppings.add(new Onion(size));}
        if (oc.getTopping_pepperoni().isSelected()){toppings.add(new Pepperoni(size));}
        if (oc.getTopping_sausage().isSelected()){toppings.add(new Sausage(size));}
        if (oc.getTopping_ham().isSelected()){toppings.add(new Ham(size));}
        // setting price of toppings based of size through method reference
        toppings.forEach(Topping::set_price);


        // constructing pizza and adding it into the order
        base.set_price();
        crust.set_price();
        return (new Pizza(size, base, crust, toppings));
    }
}
